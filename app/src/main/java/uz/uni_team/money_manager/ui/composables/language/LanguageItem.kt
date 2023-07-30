package uz.uni_team.money_manager.ui.composables.language

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.ui.composables.Spacer5Dp
import uz.uni_team.money_manager.ui.composables.button.CornerButton


@Composable
fun LanguageItem(
    modifier: Modifier,
    languages: Languages,
    isSelected: Boolean,
    onLanguageClick: (Languages) -> Unit
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (isSelected) {
            Image(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "null",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)
            )
            Spacer5Dp()
        }
        CornerButton(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp), text = languages.writeName
        ) {
            onLanguageClick.invoke(languages)
        }

    }
}