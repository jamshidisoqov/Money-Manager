package uz.uni_team.money_manager.ui.composables.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.providers.theme.Grey

@Composable
fun CornerButton(
    modifier: Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(containerColor = Grey),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 3.dp,
            pressedElevation = 1.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            text = text,
            color = Black,
            fontSize = 16.sp
        )
    }
}