package com.hynekbraun.chesstimer.domain

import com.hynekbraun.chesstimer.data.local.TimeEntity
import com.hynekbraun.chesstimer.presentation.setings.util.SettingsModel
import com.hynekbraun.chesstimer.presentation.toTimeString

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

fun TimeModel.toSettingsModel(): SettingsModel {
    return SettingsModel(
        id = id,
        name = name,
        timeStart = timeStart.toTimeString(),
        timeGain = timeGain.toTimeString(false)
    )
}

