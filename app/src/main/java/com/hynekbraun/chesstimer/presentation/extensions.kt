package com.hynekbraun.chesstimer.presentation

fun Long.toTimeString(includeHours: Boolean = true): String {
    val seconds = (this / 1000) % 60
    val minutes = (this / (1000 * 60) % 60)
    val hours = (this / (1000 * 60 * 60) % 24)
    if (!includeHours) return String.format("%02d:%02d", minutes, seconds)
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}