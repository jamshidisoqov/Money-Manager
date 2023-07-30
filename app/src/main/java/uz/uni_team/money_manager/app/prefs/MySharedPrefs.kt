package uz.uni_team.money_manager.app.prefs

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.uni_team.money_manager.ui.composables.language.Languages
import uz.uni_team.money_manager.utils.SharedPreferenceHelper
import javax.inject.Inject

class MySharedPrefs @Inject constructor(
    sharedPreferences: SharedPreferences, @ApplicationContext private val context: Context
) : SharedPreferenceHelper(context, sharedPreferences) {

    var languageCode: String by Strings(Languages.Uzbek.code)

    var isPersonalActive: Boolean by Booleans(true)

}