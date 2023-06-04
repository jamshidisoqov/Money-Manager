package uz.uni_team.money_manager.ui.composables.verify

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NumberKeyboardView(withPointKey: Boolean = false, onKeySelected: (KeypadKey) -> Unit) {
    val keypadKeys = remember(withPointKey) { getKeypadKeys(withPointKey) }
    CompositionLocalProvider(
        LocalOverscrollConfiguration provides null
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), contentPadding = PaddingValues(8.dp)
        ) {
            items(items = keypadKeys) { keypadKey ->
                when (keypadKey) {
                    is KeypadKey.Number -> {
                        KeypadButton(text = keypadKey.number.toString(),
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .height(52.dp)
                                .width(100.dp)
                                .padding(2.dp),
                            onClick = {
                                onKeySelected(keypadKey)
                            })
                    }

                    KeypadAction.Delete -> {
                        KeypadButton(color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(8.dp),
                            iconId = R.drawable.ic_erase,
                            modifier = Modifier
                                .height(52.dp)
                                .width(100.dp)
                                .padding(2.dp),
                            onClick = {
                                onKeySelected(keypadKey)
                            })

                    }

                    KeypadKey.Empty -> Spacer(modifier = Modifier)
                    KeypadKey.Point -> {
                        KeypadButton(text = ".",
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .height(52.dp)
                                .width(100.dp)
                                .padding(2.dp),
                            onClick = {
                                onKeySelected(keypadKey)
                            })
                    }
                }
            }
        }
    }
}

private fun getKeypadKeys(withPointKey: Boolean): List<KeypadKey> {
    val keys = mutableListOf<KeypadKey>()
    for (i in 1..9) keys.add(KeypadKey.Number(i))
    keys.add(if (withPointKey) KeypadKey.Point else KeypadKey.Empty)
    keys.add(KeypadKey.Number(0))
    keys.add(KeypadAction.Delete)
    return keys
}


@Composable
fun KeypadButton(
    text: String? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    @DrawableRes iconId: Int? = null,
    color: Color = Color.Transparent,
    textColor: Color = Black,
    shape: Shape = CircleShape,
    fontSize: TextUnit = 28.sp,
    modifier: Modifier
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = shape,
        enabled = enabled,
        modifier = modifier
    ) {
        text?.let {
            Text(
                text = text, fontSize = fontSize, color = textColor, fontWeight = FontWeight.W400
            )
        }
        icon?.let {
            Icon(imageVector = icon, "", tint = Black)
        }
        iconId?.let {
            Image(
                painterResource(id = it), contentDescription = null
            )
        }
    }
}
