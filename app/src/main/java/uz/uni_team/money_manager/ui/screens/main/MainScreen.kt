package uz.uni_team.money_manager.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.data.models.dto.account.AccountTypeDto
import uz.uni_team.money_manager.data.models.dto.category.CategoryDto
import uz.uni_team.money_manager.ui.composables.Spacer12Dp
import uz.uni_team.money_manager.ui.composables.Spacer8Dp
import uz.uni_team.money_manager.ui.composables.app_bar.MoneyManagerAppBar
import uz.uni_team.money_manager.ui.composables.card.LabeledCard
import uz.uni_team.money_manager.ui.screens.main.drawer.MainDrawerContent
import uz.uni_team.money_manager.ui.screens.main.drawer.UserInfo

class MainScreen : AndroidScreen() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        ModalNavigationDrawer(modifier = Modifier.fillMaxHeight(), drawerContent = {
            MainDrawerContent(
                userInfo = UserInfo(name = "Jamshid"),
                accountType = AccountTypeDto.PERSONAL,
                onProfileClick = { },
                onChangeAccount = {},
                onMainTypeClick = {})
        }) {
            MainScreenContent()
        }
    }

    @Composable
    private fun MainScreenContent() {
        Column(modifier = Modifier.fillMaxSize()) {
            MoneyManagerAppBar(titleId = R.string.app_name, actions = {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                }
            })

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                LabeledCard(
                    modifier = Modifier.fillMaxWidth(),
                    cardColor = Color.White,
                    label = stringResource(id = R.string.user_balance),
                    value = "123 000 UZS",
                    labelStyle = TextStyle(
                        color = Color.DarkGray, fontSize = 13.sp
                    ),
                    valueStyle = TextStyle(
                        color = Color.DarkGray, fontSize = 18.sp, fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer12Dp()
                Row(modifier = Modifier.fillMaxWidth()) {
                    LabeledCard(
                        modifier = Modifier.weight(1f),
                        cardColor = Color(0x5E11C739),
                        label = stringResource(id = R.string.user_income),
                        value = "+171 000 UZS",
                        labelStyle = TextStyle(
                            color = Color.DarkGray, fontSize = 13.sp
                        ),
                        valueStyle = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer8Dp()
                    LabeledCard(
                        modifier = Modifier.weight(1f),
                        cardColor = Color(0x5EEA5323),
                        label = stringResource(id = R.string.user_expanses),
                        value = "-141 000 UZS",
                        labelStyle = TextStyle(
                            color = Color.DarkGray, fontSize = 13.sp
                        ),
                        valueStyle = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }


            LazyColumn(modifier = Modifier.weight(1f)) {
                item {
                    //Category content
                    LazyRow(modifier = Modifier.fillMaxWidth()) {

                    }
                }
                //Item content
                items(count = 12) {

                }
            }
        }
    }

    @Composable
    private fun MainItem() {

    }

    @Composable
    private fun CategoryItem(
        modifier: Modifier,
        categoryDto: CategoryDto,
        selectedCategoryList: List<Long>
    ) {

    }
}
