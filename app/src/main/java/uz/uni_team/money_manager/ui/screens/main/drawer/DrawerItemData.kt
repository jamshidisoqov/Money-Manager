package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import uz.uni_team.money_manager.R

enum class DrawerItemData(@DrawableRes val iconId: Int,  @StringRes val titleId: Int,val iconColor: Color) {
    CHARTS(iconId = R.drawable.ic_charts, titleId = R.string.charts, iconColor = Color.Blue),
    COST(iconId = R.drawable.ic_cost, titleId = R.string.cost, iconColor = Color(0xFFF4719A)),
    INCOME(iconId = R.drawable.ic_income, R.string.income, iconColor = Color(0xFFFF985E)),
    CATEGORIES(
        iconId = R.drawable.ic_categories,
        titleId = R.string.categories,
        iconColor = Color(0xFF454A55)
    ),
    FAVOURITE(
        iconId = R.drawable.ic_favourite,
        titleId = R.string.favourite,
        iconColor = Color(0xFF00C3FE)
    ),
    DEBT(iconId = R.drawable.ic_debt, titleId = R.string.debt, iconColor = Color(0xFF1CD69D)),
    SETTINGS(
        iconId = R.drawable.ic_settings,
        titleId = R.string.settings,
        iconColor = Color(0xFF0F122A)
    )
}