package com.hynekbraun.chesstimer.domain

data class TimeModel(
    val id: Int,
    val name: String,
    val timeStart: Long,
    val timeGain: Long
)