package com.hynekbraun.chesstimer.presentation

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
import androidx.navigation.compose.rememberNavController
import com.hynekbraun.chesstimer.CurrentTurn
import com.hynekbraun.chesstimer.TimerViewModel
import com.hynekbraun.chesstimer.presentation.navigation.TimerNavGraph
import com.hynekbraun.chesstimer.presentation.timer.composables.MiddleBar
import com.hynekbraun.chesstimer.presentation.timer.composables.TapField
import com.hynekbraun.chesstimer.ui.theme.ChessTimerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            ChessTimerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TimerNavGraph(navController = navController)
                }
            }
        }
    }
}
