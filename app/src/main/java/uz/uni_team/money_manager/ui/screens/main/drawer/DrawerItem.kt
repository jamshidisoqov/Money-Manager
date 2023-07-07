package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme
import uz.uni_team.money_manager.ui.composables.Spacer15Dp

@Composable
fun DrawerItem(
    modifier: Modifier,
    @DrawableRes iconId: Int,
    iconColor: Color,
    @StringRes titleId: Int,
    onSelectedDrawerItem:()->Unit
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable {}
            .padding(horizontal = 4.dp, vertical = 8.dp)
        , verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color = iconColor.copy(alpha = 0.2f), shape = CircleShape),
            contentAlignment = Alignment.Center
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DrawerItemPreview() {
    MoneyManagerTheme(dynamicColor = false) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(count = 10) {
                DrawerItem(
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                        .fillMaxWidth(),
                    iconId = R.drawable.ic_charts,
                    iconColor = Color.Blue,
                    titleId = R.string.charts
                ){

                }
            }
        }
    }
}