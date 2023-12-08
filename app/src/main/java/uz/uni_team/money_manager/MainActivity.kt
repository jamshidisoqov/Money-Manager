package uz.uni_team.money_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import dagger.hilt.android.AndroidEntryPoint
import uz.uni_team.money_manager.providers.theme.MoneyManagerTheme
import uz.uni_team.money_manager.ui.screens.splash.SplashScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyManagerTheme(dynamicColor = false, darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Navigator(screen = SplashScreen(), onBackPressed = { true }) {
                        FadeTransition(navigator = it)
                    }
                }
            }
        }
    }
}
