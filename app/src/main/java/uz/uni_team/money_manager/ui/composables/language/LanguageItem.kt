package uz.uni_team.money_manager.ui.composables.language

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.uni_team.money_manager.ui.composables.button.CornerButton


@Composable
fun LanguageItem(modifier: Modifier, languages: Languages, onLanguageClick: (Languages) -> Unit) {

    Column(modifier = modifier) {
        CornerButton(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            text = languages.writeName
        ) {
            onLanguageClick.invoke(languages)
        }

    }
}