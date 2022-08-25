package com.hynekbraun.chesstimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hynekbraun.chesstimer.composables.MiddleBar
import com.hynekbraun.chesstimer.composables.TapField
import com.hynekbraun.chesstimer.ui.theme.ChessTimerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<TimerViewModel>()
            ChessTimerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TapField(
                            textColor = Color.Black,
                            modifier = Modifier
                                .weight(2f)
                                .fillMaxWidth()
                                .background(Color.White),
                            rotation = -180f,
                            onFieldClick = {
                                if (viewModel.currentTurn != CurrentTurn.TWO)
                                    viewModel.startTimer()
                            },
                            time = viewModel.time1AsString.value
                        )
                        MiddleBar(
                            isActive = false,
                            onSettingsClicked = {},
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
                                if (viewModel.currentTurn != CurrentTurn.ONE)
                                    viewModel.startTimer()
                            },
                            time = viewModel.time2AsString.value
                        )
                    }
                }
            }
        }
    }
}
