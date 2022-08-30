package com.hynekbraun.chesstimer.data.local.timedatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hynekbraun.chesstimer.domain.TimeModel

@Entity(tableName = "chess_time")
data class TimeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "time_start") val timeStart: Long,
    @ColumnInfo(name = "time_gain") val timeGain: Long
)

fun TimeEntity.toTimeModel(): TimeModel {
    return TimeModel(
        id = id,
        name = name,
        timeStart = timeStart,
        timeGain = timeGain
    )
}