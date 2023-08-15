package uz.uni_team.money_manager.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.uni_team.money_manager.data.repository.monem.MonemRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val monemRepository: MonemRepository
) : MainViewModel, ViewModel() {

    override val container: Container<MainUiState, Nothing> = container(MainUiState.Loading)

    init {
        intent {
            monemRepository.calculateIncomeExpansesAndBalance()
                .onStart {
                    reduce { MainUiState.Loading }
                }.catch { th ->
                    reduce { MainUiState.Failed(th.message) }
                }.collectLatest { data ->
                    reduce {
                        MainUiState.Success(incomeExpansesAndBalanceMap = data)
                    }
                }
        }
    }

    override fun onEventDispatcher(event: MainIntent) = intent {
        when (event) {
            is MainIntent.DeleteMonem -> {

            }

            MainIntent.OnAddedMonemClick -> {

            }

            is MainIntent.OnChangedMonemClick -> {

            }

            is MainIntent.OnDeleteClickMonem -> {

            }

            is MainIntent.OnProfileChanged -> {

            }

            MainIntent.OnProfileClick -> {

            }

            is MainIntent.OnQueryChanged -> {

            }

            is MainIntent.OnSelectedDate -> {

            }

            MainIntent.OnSelectedDateClick -> {

            }

            is MainIntent.OnSelectedDrawerType -> {

            }

            is MainIntent.SelectedCategory -> {

            }
        }
    }
}