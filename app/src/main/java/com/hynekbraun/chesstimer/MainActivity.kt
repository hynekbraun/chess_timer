package com.hynekbraun.chesstimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
            ChessTimerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TapField(
                            textColor = Color.White,
                            modifier = Modifier
                                .weight(2f)
                                .fillMaxWidth()
                                .background(Color.Black),
                            rotation = -180f,
                            onFieldClick = {/* FINISH ROUND timer */},
                        )
                        MiddleBar(
                            isActive = false,
                            onSettingsClicked = {},
                            onPauseClicked = {},
                            onResetClicked = {},
                            modifier = Modifier.weight(1f)
                        )
                        TapField(
                            textColor = Color.Black,
                            modifier = Modifier
                                .weight(2f)
                                .fillMaxWidth()
                                .background(Color.White),
                            onFieldClick = {/* FINISH ROUND timer */}
                        )
                    }
                }
            }
        }
    }
}
