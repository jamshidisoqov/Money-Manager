package uz.uni_team.money_manager.ui.screens.langugage

import uz.uni_team.money_manager.ui.composables.language.Languages

data class LanguageUiState(
    val isLoading:Boolean = false,
    val isError:Boolean = false,
    val errorMessage:String? = null,
    val currentLanguage:Languages? = null
)
