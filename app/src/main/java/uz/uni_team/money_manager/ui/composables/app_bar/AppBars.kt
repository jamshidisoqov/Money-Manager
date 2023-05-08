package uz.uni_team.money_manager.ui.composables.app_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uni_team.money_manager.providers.theme.Hint
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
            ),
        shadowElevation = 2.dp
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
            modifier = Modifier.padding(start = 16.dp),
            text = subTitle,
            color = Hint
        )
    }
}