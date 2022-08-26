package com.hynekbraun.chesstimer.domain

import com.hynekbraun.chesstimer.data.local.TimeEntity

data class TimeModel(
    val id: Int,
    val name: String,
    val timeStart: Long,
    val timeGain: Long
)

fun TimeModel.toEntity(): TimeEntity {
    return TimeEntity(
        id = id,
        name = name,
        timeStart = timeStart,
        timeGain = timeGain
    )
}