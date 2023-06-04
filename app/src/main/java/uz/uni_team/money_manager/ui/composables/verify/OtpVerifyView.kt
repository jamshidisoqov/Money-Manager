package uz.uni_team.money_manager.ui.composables.verify

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme


@Composable
fun SmsCodeView(
    modifier: Modifier,
    code: String,
    codeLength: SmsCodeLength = SmsCodeLength.SMALL
) {
    val smsCodeLength = codeLength.length
    Row(modifier = modifier) {
        for (i in 0 until smsCodeLength) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                val isInput = code.length - 1 >= i
                Text(
                    text = (if (isInput) code[i].toString() else "#"),
                    fontSize = codeLength.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = if (isInput) Black else DarkGray
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .height(6.dp)
                        .background(
                            color = if (isInput) MaterialTheme.colorScheme.primary else DarkGray,
                            shape = CircleShape
                        )
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SmsCodeViewPreview() {
    MoneyManagerTheme(dynamicColor = false) {
        SmsCodeView(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            code = "123"
        )
    }
}

enum class SmsCodeLength(val length: Int, val fontSize: TextUnit) {
    SMALL(4, 24.sp), MIDDLE(5, 22.sp), LARGE(6, 20.sp)
}