package uz.uni_team.money_manager.ui.screens.verify

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.ui.composables.FillAvailableSpace
import uz.uni_team.money_manager.ui.composables.verify.KeypadAction
import uz.uni_team.money_manager.ui.composables.verify.KeypadKey
import uz.uni_team.money_manager.ui.composables.verify.NumberKeyboardView
import uz.uni_team.money_manager.ui.composables.verify.SmsCodeLength
import uz.uni_team.money_manager.ui.composables.verify.SmsCodeView
import uz.uni_team.money_manager.ui.composables.button.ProgressButton

val SMS_CODE_LENGTH = SmsCodeLength.SMALL

class VerifyScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        VerifyScreenContent()
    }

    @Composable
    private fun VerifyScreenContent() {
        Column(modifier = Modifier.fillMaxSize()) {
            var code: String by remember { mutableStateOf("") }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "ic_back"
                )
                Text(
                    text = stringResource(id = R.string.phone_verification),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(text = stringResource(id = R.string.enter_sms_code), color = Color.Black)
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                FillAvailableSpace()

                SmsCodeView(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .height(100.dp),
                    code = code,
                    codeLength = SMS_CODE_LENGTH
                )

                FillAvailableSpace()

                ProgressButton(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .heightIn(min = 48.dp),
                    isEnabled = code.length == 4,
                    text = stringResource(id = R.string.verify_now)
                ) {

                }
                FillAvailableSpace()
                NumberKeyboardView { keypadKey ->
                    when (keypadKey) {
                        KeypadAction.Delete -> {
                            code = if (code.isNotEmpty()) code.dropLast(1) else code
                        }

                        is KeypadKey.Number -> {
                            code = if (code.length < SMS_CODE_LENGTH.length) code.plus(keypadKey.number) else code
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}