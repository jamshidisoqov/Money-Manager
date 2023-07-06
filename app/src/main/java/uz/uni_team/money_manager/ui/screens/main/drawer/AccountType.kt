package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.annotation.IntDef
import uz.uni_team.money_manager.ui.screens.main.drawer.AccountType.Companion.FAMILY
import uz.uni_team.money_manager.ui.screens.main.drawer.AccountType.Companion.PERSONAL

@Retention
@IntDef(value = [PERSONAL, FAMILY])
annotation class AccountType {
    companion object {
        const val PERSONAL = 0
        const val FAMILY = 1
    }
}
