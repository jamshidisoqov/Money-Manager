package uz.uni_team.money_manager.ui.screens.langugage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.flowWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.orbitmvi.orbit.compose.collectAsState
import uz.uni_team.money_manager.R
import uz.uni_team.money_manager.providers.language.updateResources
import uz.uni_team.money_manager.providers.theme.Grey
import uz.uni_team.money_manager.ui.composables.MonemLoadingView
import uz.uni_team.money_manager.ui.composables.Spacer15Dp
import uz.uni_team.money_manager.ui.composables.Spacer24Dp
import uz.uni_team.money_manager.ui.composables.Spacer2Dp
import uz.uni_team.money_manager.ui.composables.Spacer50Dp
import uz.uni_team.money_manager.ui.composables.button.CornerButton
import uz.uni_team.money_manager.ui.composables.language.LanguageItem
import uz.uni_team.money_manager.ui.composables.language.Languages
import uz.uni_team.money_manager.ui.screens.main.MainScreen

class LanguageScreen : AndroidScreen() {
    @Composable
    override fun Content() {

        val viewModel: LanguageViewModel = getViewModel()
        val lifecycle = LocalLifecycleOwner.current.lifecycle
        val navigator = LocalNavigator.current
        val uiState = viewModel.collectAsState().value
        val context = LocalContext.current

        LaunchedEffect(key1 = Unit) {
            viewModel.changeLanguage.flowWithLifecycle(lifecycle).collect {
                uiState.currentLanguage?.let { updateResources(it.code, context) }
            }
        }
        LanguageScreenContent(uiState, viewModel::onEventDispatcher) {
            navigator?.push(MainScreen())
        }
    }
}

@Composable
fun LanguageScreenContent(
    uiState: LanguageUiState,
    onEventDispatcher: (LanguageIntent) -> Unit,
    navigateToMain: () -> Unit
) {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Spacer15Dp()

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(percent = 30))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer15Dp()
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 21.sp,
                color = Black,
                style = TextStyle(fontWeight = FontWeight.ExtraBold)
            )
        }

        Spacer50Dp()

        Text(
            text = stringResource(id = R.string.choose_lang_uz),
            fontSize = 36.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 2.sp,
            color = Black
        )

        Text(
            text = stringResource(id = R.string.choose_lang_ru),
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            color = Grey,
            letterSpacing = 2.sp
        )

        Spacer50Dp()
        if (uiState.isLoading) {
            MonemLoadingView(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        } else {
            for (language in Languages.values()) {
                LanguageItem(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    isSelected = language == uiState.currentLanguage,
                    languages = language
                ) {
                    onEventDispatcher(LanguageIntent.LanguageSelected(language))
                }
                Spacer2Dp()
            }
            Spacer24Dp()
            CornerButton(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                text = stringResource(id = R.string.next),
                onClick = navigateToMain
            )
        }
    }
}