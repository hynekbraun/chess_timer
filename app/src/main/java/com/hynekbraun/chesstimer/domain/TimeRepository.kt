package com.hynekbraun.chesstimer.domain

import kotlinx.coroutines.flow.Flow


interface TimeRepository {

    fun getTime(): Flow<List<TimeModel>>

    suspend fun deleteTime(id: Int)

    suspend fun insertTime(time: TimeModel)

    suspend fun getTimeById(id: Int): TimeModel?
}