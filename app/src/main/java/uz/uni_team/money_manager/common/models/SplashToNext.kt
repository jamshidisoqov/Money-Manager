package uz.uni_team.money_manager.common.models

import androidx.annotation.IntDef
import uz.uni_team.money_manager.common.models.SplashToNext.Companion.LOGIN
import uz.uni_team.money_manager.common.models.SplashToNext.Companion.MAIN

@Retention
@IntDef(value = [LOGIN, MAIN])
annotation class SplashToNext {
    companion object {
        const val LOGIN = 0
        const val MAIN = 1
    }
}