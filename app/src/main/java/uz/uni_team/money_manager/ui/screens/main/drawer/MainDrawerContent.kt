package uz.uni_team.money_manager.ui.screens.main.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme
import uz.uni_team.money_manager.ui.composables.FillAvailableSpace
import uz.uni_team.money_manager.ui.composables.Spacer12Dp
import uz.uni_team.money_manager.ui.composables.Spacer15Dp
import uz.uni_team.money_manager.ui.composables.Spacer5Dp
import uz.uni_team.money_manager.ui.composables.Spacer8Dp

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
            .background(Color(0xFFF7F7F0))
    ) {
        Spacer12Dp()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer12Dp()
            AsyncImage(
                model = userInfo?.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(percent = 30)),
                placeholder = painterResource(id = R.drawable.logo)
            )

            Spacer15Dp()

            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = userInfo?.name ?: stringResource(id = R.string.not_register),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.Black
                )
                Spacer5Dp()
                Text(
                    text = userInfo?.phoneNumber ?: stringResource(id = R.string.not_register),
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }

            FillAvailableSpace()
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_forward), contentDescription = ""
                )
            }
            Spacer12Dp()
        }

        Spacer15Dp()

        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .clip(RoundedCornerShape(percent = 30))
                .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.22f))
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Personal",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500
            )
            FillAvailableSpace()
            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_convert), contentDescription = ""
                )
            }
        }

       Spacer8Dp()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(count = 10) {
                DrawerItem(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 2.dp)
                        .fillMaxWidth(),
                    iconId = R.drawable.ic_charts,
                    iconColor = Color.Blue,
                    titleId = R.string.charts
                ) {

                }
            }
        }

        Spacer12Dp()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainContentPreview() {
    MoneyManagerTheme(dynamicColor = false) {
        Column(modifier = Modifier.fillMaxSize()) {
            MainDrawerContent(userInfo = UserInfo("", "Jamshid Isoqov", "+99890 714 41 02"),
                accountType = AccountType(),
                onProfileClick = { },
                onChangeAccount = {},
                onMainTypeClick = {})
        }
    }
}