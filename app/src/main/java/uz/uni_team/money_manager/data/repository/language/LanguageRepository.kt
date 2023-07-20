package uz.uni_team.money_manager.data.repository.language

import uz.uni_team.money_manager.app.prefs.MySharedPrefs
import uz.uni_team.money_manager.ui.composables.language.Languages
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LanguageRepository @Inject constructor(
    private val mySharedPrefs: MySharedPrefs
) {

    fun setLanguage(languages: Languages) {
        mySharedPrefs.languageCode = languages.code
    }

    fun getLanguage(): Languages {
        return Languages.values().first { it.code == mySharedPrefs.languageCode }
    }

}