package uz.uni_team.money_manager.providers.language

import android.content.Context
import java.util.Locale

fun updateResources(language: String, context: Context) {
    val locale = Locale(language)
    val resources = context.resources
    val configuration = resources.configuration
    configuration.setLocale(locale)
    resources.updateConfiguration(configuration, resources.displayMetrics)
}