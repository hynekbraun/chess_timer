package com.hynekbraun.chesstimer.presentation.timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hynekbraun.chesstimer.TimerViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hynekbraun.chesstimer.CurrentTurn
import com.hynekbraun.chesstimer.presentation.timer.composables.MiddleBar
import com.hynekbraun.chesstimer.presentation.timer.composables.TapField

@Composable
fun TimerScreen(
    modifier: Modifier = Modifier,
    viewModel: TimerViewModel = viewModel(),
    onSettingsClicked: () -> Unit
) {
    Column(modifier = modifier) {
        TapField(
            textColor = Color.Black,
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .background(Color.White),
            rotation = -180f,
            onFieldClick = {
                if (viewModel.state.currentTurn != CurrentTurn.TWO)
                    viewModel.startTimer()
            },
            time = viewModel.state.player1TimeLeft
        )
        MiddleBar(
            isActive = false,
            onSettingsClicked = { onSettingsClicked() },
            onPauseClicked = {},
            onResetClicked = {
                viewModel.resetTimer()
            },
            modifier = Modifier.weight(1f)
        )
        TapField(
            textColor = Color.White,
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .background(Color.Black),
            onFieldClick = {
                if (viewModel.state.currentTurn != CurrentTurn.ONE)
                    viewModel.startTimer()
            },
            time = viewModel.state.player2TimeLeft
        )
    }
}