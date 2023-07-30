package uz.uni_team.money_manager.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor():MainViewModel,ViewModel() {

    override val container: Container<MainUiState, Nothing> = container(MainUiState.Loading)

    override fun onEventDispatcher(event: MainIntent)  = intent{
        when (event) {
            is MainIntent.DeleteMonem -> TODO()
            MainIntent.OnAddedMonemClick -> TODO()
            is MainIntent.OnChangedMonemClick -> TODO()
            is MainIntent.OnDeleteClickMonem -> TODO()
            is MainIntent.OnProfileChanged -> TODO()
            MainIntent.OnProfileClick -> TODO()
            is MainIntent.OnQueryChanged -> TODO()
            is MainIntent.OnSelectedDate -> TODO()
            MainIntent.OnSelectedDateClick -> TODO()
            is MainIntent.OnSelectedDrawerType -> TODO()
            is MainIntent.SelectedCategory -> TODO()
        }
    }
}