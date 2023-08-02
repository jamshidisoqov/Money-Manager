package uz.uni_team.money_manager.ui.screens.main

import uz.uni_team.money_manager.data.models.dto.account.AccountDto
import uz.uni_team.money_manager.data.models.dto.category.CategoryDto
import uz.uni_team.money_manager.data.models.dto.monem.MonemDto
import uz.uni_team.money_manager.ui.screens.main.drawer.DrawerItemData
import java.util.Date

sealed interface MainIntent {
    data class OnQueryChanged(val query:String? = ""):MainIntent
    object OnSelectedDateClick:MainIntent
    data class OnSelectedDate(val startDate:Date?,val endDate: Date?):MainIntent
    object OnAddedMonemClick:MainIntent
    data class OnChangedMonemClick(val monemDto: MonemDto):MainIntent
    data class OnDeleteClickMonem(val monemDto: MonemDto):MainIntent
    data class DeleteMonem(val monemDto: MonemDto):MainIntent
    data class SelectedCategory(val isSelected:Boolean,val categoryDto: CategoryDto):MainIntent
    data class OnSelectedDrawerType(val drawerType: DrawerItemData):MainIntent
    object OnProfileClick:MainIntent
    data class OnProfileChanged(val isPersonal:Boolean):MainIntent
}