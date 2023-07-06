package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.ui.composables.Spacer15Dp

@Composable
fun DrawerItem(
    modifier: Modifier, @DrawableRes iconId: Int, iconColor: Color, @StringRes titleId: Int
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color = iconColor.copy(alpha = 0.2f))
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(color = iconColor)
            )
        }
        Spacer15Dp()

        Text(
            text = stringResource(id = titleId),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.W700
        )
    }
}