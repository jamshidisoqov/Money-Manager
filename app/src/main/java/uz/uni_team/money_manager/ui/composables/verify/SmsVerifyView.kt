package uz.uni_team.money_manager.ui.composables.verify

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SmsCodeView(
    smsCodeLength: Int,
    textFieldColors: TextFieldColors,
    textStyle: TextStyle,
    smsCode: String? = null,
    readOnly: Boolean = false,
    smsFulled: ((String) -> Unit)?
) {
    val focusRequesters: List<FocusRequester> = remember {
        (0 until smsCodeLength).map { FocusRequester() }
    }
    val enteredNumbers = remember(smsCode, smsCodeLength) {
        mutableStateListOf(
            * if (readOnly && smsCode != null) getSmsCodeText(smsCode = smsCode, smsCodeLength)
            else ((0 until smsCodeLength).map { "" }.toTypedArray())
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (index in 0 until smsCodeLength) {
            OutlinedTextField(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = if (enteredNumbers[index].isNotEmpty()) MaterialTheme.colorScheme.primary else Color.DarkGray,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .weight(1f)
                    .focusRequester(focusRequesters[index])
                    .onKeyEvent { keyEvent: KeyEvent ->
                        val currentValue = enteredNumbers.getOrNull(index) ?: ""
                        if (keyEvent.key == Key.Backspace) {
                            if (currentValue.isNotEmpty()) {
                                enteredNumbers[index] = ""
                                smsFulled?.invoke(enteredNumbers.joinToString(separator = ""))
                            } else {
                                focusRequesters
                                    .getOrNull(index.minus(1))
                                    ?.requestFocus()
                            }
                        }
                        false
                    },
                textStyle = textStyle,
                singleLine = true,
                readOnly = readOnly,
                value = enteredNumbers.getOrNull(index)?.trim() ?: "",
                maxLines = 1,
                placeholder = {
                    Text(
                        text = "•",
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                colors = textFieldColors,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { value: String ->
                    when {
                        value.isDigitsOnly() -> {
                            if (focusRequesters[index].freeFocus()) {
                                when (value.length) {
                                    1 -> {
                                        enteredNumbers[index] = value.trim()
                                        smsFulled?.invoke(enteredNumbers.joinToString(separator = ""))
                                        focusRequesters.getOrNull(index + 1)?.requestFocus()
                                    }

                                    2 -> {
                                        focusRequesters.getOrNull(index + 1)?.requestFocus()
                                    }

                                    else -> {
                                        return@OutlinedTextField
                                    }
                                }
                            }
                        }

                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.NumberPassword,
                ),
                visualTransformation = PasswordVisualTransformation()
            )
            val fulled = enteredNumbers.joinToString(separator = "")
            if (fulled.length == smsCodeLength) {
                smsFulled?.invoke(fulled)
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}


private fun getSmsCodeText(smsCode: String, smsCodeLength: Int): Array<String> {
    val smsCodes: MutableList<String> = smsCode.map { char -> char.toString() }.toMutableList()
    while (smsCodes.size != smsCodeLength) {
        smsCodes.add("")
    }
    return smsCodes.toTypedArray()
}




