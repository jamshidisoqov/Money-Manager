package uz.uni_team.money_manager.ui.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Spacer2Dp() {
    Spacer(modifier = Modifier.size(2.dp))
}


@Composable
fun Spacer5Dp() {
    Spacer(modifier = Modifier.size(5.dp))
}

@Composable
fun Spacer8Dp() {
    Spacer(modifier = Modifier.size(8.dp))
}

@Composable
fun Spacer10Dp() {
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun SpacerWithHeight(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun Spacer12Dp() {
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
fun Spacer15Dp() {
    Spacer(modifier = Modifier.size(15.dp))
}

@Composable
fun Spacer16Dp() {
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
fun Spacer20Dp() {
    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun Spacer24Dp() {
    Spacer(modifier = Modifier.size(24.dp))
}

@Composable
fun Spacer30Dp() {
    Spacer(modifier = Modifier.size(30.dp))
}

@Composable
fun Spacer50Dp() {
    Spacer(modifier = Modifier.size(50.dp))
}

@Composable
fun ColumnScope.FillAvailableSpace() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun RowScope.FillAvailableSpace() {
    Spacer(modifier = Modifier.weight(1f))
}