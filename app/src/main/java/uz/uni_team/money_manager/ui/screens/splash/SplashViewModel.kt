package uz.uni_team.money_manager.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.uni_team.money_manager.common.models.SplashToNext
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _openNextScreen = Channel<SplashToNext>()
    val openNextScreen get() = _openNextScreen.receiveAsFlow()

    fun nextScreen(){
        viewModelScope.launch {

        }
    }

}