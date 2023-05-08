package uz.uni_team.money_manager.ui.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.delay
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme
import uz.uni_team.money_manager.ui.screens.langugage.LanguageScreen

class SplashScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        SplashScreenContent {
            navigator?.push(LanguageScreen())
        }
    }
}

@Composable
private fun SplashScreenContent(onAnimationComplete: () -> Unit) {
    val scale = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                })
        )
        delay(1000)
        onAnimationComplete()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(percent = 30))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(scale.value),
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    MoneyManagerTheme(dynamicColor = false) {
        SplashScreenContent {

        }
    }
}