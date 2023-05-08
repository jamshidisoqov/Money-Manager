package uz.uni_team.money_manager.ui.composables.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProgressButton(
    modifier: Modifier,
    text: String,
    isEnabled: Boolean = true,
    isProgress: Boolean = false,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        if (isProgress) {
            CircularProgressIndicator()
        } else {
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}