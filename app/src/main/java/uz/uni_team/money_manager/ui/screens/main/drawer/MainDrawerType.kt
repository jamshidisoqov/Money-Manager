package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.annotation.IntDef
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.CATEGORIES
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.CHARTS
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.COST
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.DEBT
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.FAVOURITES
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.INCOME
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.PREMIUM
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerType.Companion.SETTINGS

@Retention
@IntDef(
    value = [CHARTS, COST, INCOME, CATEGORIES, FAVOURITES, DEBT, SETTINGS, PREMIUM]
)
annotation class MainDrawerType {
    companion object {
        const val CHARTS = 0
        const val COST = 1
        const val INCOME = 2
        const val CATEGORIES = 3
        const val FAVOURITES = 4
        const val DEBT = 5
        const val SETTINGS = 6
        const val PREMIUM = 7
    }
}
