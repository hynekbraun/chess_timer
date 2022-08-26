package com.hynekbraun.chesstimer.domain

import kotlinx.coroutines.flow.Flow


interface TimeRepository {

    fun getTime(): Flow<List<TimeModel>>

    suspend fun deleteTime(time: TimeModel)

    suspend fun insertTime(time: TimeModel)
}