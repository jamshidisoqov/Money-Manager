package uz.uni_team.money_manager.common

import org.orbitmvi.orbit.ContainerHost

interface BaseViewModel<INTENT : Any, STATE : Any, SIDE_EFFECT : Any> :
    ContainerHost<STATE, SIDE_EFFECT> {

    fun onEventDispatcher(event: INTENT)

}
