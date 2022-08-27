package com.hynekbraun.chesstimer.presentation.setings.addtimer.util

data class AddTimerState(
    val hours: String = "00",
    val minutes: String = "00",
    val seconds: String = "00",
    val incrementMinutes: String = "00",
    val incrementSeconds: String = "00"
)
