package com.hynekbraun.chesstimer.presentation.timer.util

import com.hynekbraun.chesstimer.CurrentTurn

data class TimerScreenState(
    val player1TimeLeft: String = "",
    val player1Turns: Int = 0,
    val player2TimeLeft: String = "",
    val player2Turns: Int = 0,
    val currentTurn: CurrentTurn = CurrentTurn.NOBODY
)
