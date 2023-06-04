package uz.uni_team.money_manager.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.common.UzbNumberVisualTransformation
import uz.uni_team.money_manager.providers.theme.Primary
import uz.uni_team.money_manager.ui.composables.FillAvailableSpace
import uz.uni_team.money_manager.ui.composables.Spacer12Dp
import uz.uni_team.money_manager.ui.composables.Spacer24Dp
import uz.uni_team.money_manager.ui.composables.app_bar.AppBarWithSubtitle
import uz.uni_team.money_manager.ui.composables.button.ProgressButton
import uz.uni_team.money_manager.ui.composables.text_fields.BasicTextField

class RegisterScreen : AndroidScreen() {
    @Composable
    override fun Content() {

    }

    @Composable
    private fun RegisterScreenContent() {
        Column(Modifier.fillMaxSize()) {

            var name: String by remember {
                mutableStateOf("")
            }

            var phoneNumber: String by remember {
                mutableStateOf("+998")
            }

            var password: String by remember {
                mutableStateOf("")
            }

            var progressState: Boolean by remember { mutableStateOf(false) }

            AppBarWithSubtitle(
                title = stringResource(id = R.string.login),
                subTitle = stringResource(id = R.string.login_detail)
            )

            Spacer24Dp()

            BasicTextField(
                text = name, hint = "Name", keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                ), description = stringResource(id = R.string.please_enter_name)
            ) {
                name = it
            }

            Spacer24Dp()

            BasicTextField(
                text = phoneNumber,
                hint = "+99890 ###-##-##",
                visualTransformation = UzbNumberVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next
                ),
                description = stringResource(id = R.string.please_enter_phone_number)
            ) {
                phoneNumber = it
            }

            Spacer24Dp()

            BasicTextField(
                text = password, hint = "*********", keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
                ), description = stringResource(id = R.string.please_enter_password)
            ) {
                password = it
            }
            FillAvailableSpace()

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer12Dp()
                Text(text = stringResource(id = R.string.not_register_yet))

                FillAvailableSpace()
                Text(
                    text = stringResource(id = R.string.login),
                    color = Primary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Spacer12Dp()
            }

            Spacer12Dp()

            ProgressButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                isEnabled = !progressState,
                isProgress = progressState,
                text = stringResource(id = R.string.register)
            ) {
                progressState = true
            }
        }
    }
}

