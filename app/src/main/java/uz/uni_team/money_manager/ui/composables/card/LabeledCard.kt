package uz.uni_team.money_manager.ui.composables.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme
import uz.uni_team.money_manager.ui.composables.Spacer12Dp
import uz.uni_team.money_manager.ui.composables.Spacer5Dp
import uz.uni_team.money_manager.ui.composables.Spacer8Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabeledCard(
    modifier: Modifier,
    cardColor: Color,
    label: String,
    value: String,
    labelStyle: TextStyle,
    valueStyle: TextStyle,
    trailingIcon: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(percent = 30),
        onClick = {}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = cardColor)
                .padding(horizontal = 12.dp)
        ) {
            Spacer8Dp()
            Text(text = label, style = labelStyle)
            Spacer5Dp()
            Text(text = value, style = valueStyle)
            Spacer8Dp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LabeledCardPreview() {
    MoneyManagerTheme(dynamicColor = false) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            LabeledCard(
                modifier = Modifier.fillMaxWidth(),
                cardColor = Color.White,
                label = "Balance",
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
                    label = "Income",
                    value = "+171 000 UZS",
                    labelStyle = TextStyle(
                        color = Color.DarkGray, fontSize = 13.sp
                    ),
                    valueStyle = TextStyle(
                        color = Color.DarkGray, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer8Dp()
                LabeledCard(
                    modifier = Modifier.weight(1f),
                    cardColor = Color(0x5EEA5323),
                    label = "Expanses",
                    value = "-141 000 UZS",
                    labelStyle = TextStyle(
                        color = Color.DarkGray, fontSize = 13.sp
                    ),
                    valueStyle = TextStyle(
                        color = Color.DarkGray, fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                    )
                )
            }

        }
    }
}