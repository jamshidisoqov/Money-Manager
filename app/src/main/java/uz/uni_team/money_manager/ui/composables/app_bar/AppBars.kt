package uz.uni_team.money_manager.ui.composables.app_bar

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.providers.theme.Hint
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme
import uz.uni_team.money_manager.ui.composables.Spacer12Dp

@Composable
fun AppBar(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
            ), shadowElevation = 2.dp
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun AppBarWithSubtitle(title: String, subTitle: String) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer12Dp()
        Text(
            modifier = Modifier.padding(start = 16.dp), text = subTitle, color = Hint
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoneyManagerAppBar(
    @StringRes titleId: Int? = null,
    titleStr: String? = null,
    titleTextColor: Color = MaterialTheme.colorScheme.primary,
    onNavigateBack: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(title = {
        Text(
            text = if (titleId != null) stringResource(id = titleId)
            else titleStr ?: "", color = titleTextColor
        )
    }, navigationIcon = {
        IconButton(onClick = { onNavigateBack() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }, actions = actions
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppBarPreview() {
    MoneyManagerTheme(dynamicColor = false) {
        MoneyManagerAppBar(onNavigateBack = { }, titleStr = "Home", actions = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        })
    }
}

