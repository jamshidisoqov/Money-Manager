package uz.uni_team.money_manager.common.models

import androidx.annotation.StringDef
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.CATEGORIES
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.CHARTS
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.COST
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.DEBT
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.FAVOURITES
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.INCOME
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.PREMIUM
import uz.uni_team.money_manager.common.models.MainDrawerType.Companion.SETTINGS

@Retention
@StringDef(
    value = [CHARTS, COST, INCOME, CATEGORIES, FAVOURITES, DEBT, SETTINGS, PREMIUM]
)
annotation class MainDrawerType {
    companion object {
        const val CHARTS = "CHARTS"
        const val COST = "CHARTS"
        const val INCOME = "INCOME"
        const val CATEGORIES = "CATEGORIES"
        const val FAVOURITES = "FAVOURITES"
        const val DEBT = "DEBT"
        const val SETTINGS = "SETTINGS"
        const val PREMIUM = "PREMIUM"
    }
}
