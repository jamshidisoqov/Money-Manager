package uz.uni_team.money_manager.ui.screens.langugage

import uz.uni_team.money_manager.ui.composables.language.Languages

sealed interface LanguageIntent{
    class LanguageSelected(val languages: Languages):LanguageIntent
}