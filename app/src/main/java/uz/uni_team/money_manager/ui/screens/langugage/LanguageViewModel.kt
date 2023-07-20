package uz.uni_team.money_manager.ui.screens.langugage

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.uni_team.money_manager.common.BaseViewModel
import uz.uni_team.money_manager.data.repository.language.LanguageRepository
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val languageRepository: LanguageRepository
) : ViewModel(), BaseViewModel<LanguageIntent, LanguageUiState, Nothing> {

    override val container: Container<LanguageUiState, Nothing> =
        container(initialState = LanguageUiState())

    private val _changeLanguage:Channel<Unit> = Channel(Channel.BUFFERED)
    val changeLanguage:Flow<Unit> get() = _changeLanguage.receiveAsFlow()

    override fun onEventDispatcher(event: LanguageIntent) = intent {
        when (event) {
            is LanguageIntent.LanguageSelected -> {
                reduce { LanguageUiState(isLoading = true) }
                languageRepository.setLanguage(event.languages)
                reduce { LanguageUiState(isLoading = false, currentLanguage = event.languages) }
                _changeLanguage.send(Unit)
            }
        }
    }
}
