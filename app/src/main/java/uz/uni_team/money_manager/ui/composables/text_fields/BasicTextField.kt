package uz.uni_team.money_manager.ui.composables.text_fields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.uni_team.money_manager.providers.theme.Hint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTextField(
    text: String,
    hint: String,
    description: String? = null,
    errorDescription: String? = null,
    editable: Boolean = true,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChanged: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(
                    RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = text,
                enabled = editable,
                onValueChange = onValueChanged,
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent

                ),
                visualTransformation = visualTransformation,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                keyboardActions = KeyboardActions(onDone = {}, onGo = {}),
                placeholder = {
                    Text(text = hint, color = Hint)
                },
            )
        }

        description?.let {
            if (errorDescription == null)
                Text(text = it, color = Hint, modifier = Modifier.padding(12.dp))
        }

        errorDescription?.let {
            Text(text = it, color = Color.Red, modifier = Modifier.padding(12.dp))
        }
    }
}


