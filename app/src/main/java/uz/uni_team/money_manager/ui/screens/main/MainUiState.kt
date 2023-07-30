package uz.uni_team.money_manager.ui.screens.main

import uz.uni_team.money_manager.data.models.dto.account.AccountDto
import uz.uni_team.money_manager.data.models.dto.category.CategoryDto
import uz.uni_team.money_manager.data.models.dto.monem.MonemTypeDto
import java.math.BigDecimal
import java.util.Date

sealed interface MainUiState {
    object Loading : MainUiState
    data class Failed(val message: String?) : MainUiState
    data class Success(
        val incomeExpansesAndBalanceMap: Map<MonemTypeDto, BigDecimal> = mapOf(),
        val categories: List<CategoryDto> = emptyList(),
        val accounts: List<AccountDto> = emptyList(),
        val currentAccountDto: AccountDto? = null,
        val selectedCategoriesIds: List<Int> = emptyList(),
        val selectedDates: Pair<Date?, Date?> = Pair(null, null),
        val isPersonal:Boolean = true
    ):MainUiState
}