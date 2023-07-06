package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.ui.composables.Spacer15Dp

@Composable
fun MainDrawerContent(
    userInfo: UserInfo?,
    accountType: AccountType,
    onProfileClick: () -> Unit,
    onChangeAccount: (AccountType) -> Unit,
    onMainTypeClick: (MainDrawerType) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(350.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF7F7F7))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        ) {
            AsyncImage(
                model = userInfo?.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer15Dp()
            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = userInfo?.name ?: stringResource(id = R.string.not_register),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = userInfo?.phoneNumber ?: stringResource(id = R.string.not_register),
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

