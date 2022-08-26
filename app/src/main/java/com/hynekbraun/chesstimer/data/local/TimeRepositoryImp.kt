package com.hynekbraun.chesstimer.data.local

import com.hynekbraun.chesstimer.domain.TimeModel
import com.hynekbraun.chesstimer.domain.TimeRepository
import com.hynekbraun.chesstimer.domain.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeRepositoryImp
@Inject constructor(private val timeDao: TimeDao) : TimeRepository {
    override fun getTime(): Flow<List<TimeModel>> {
        return flow {
            timeDao.observeAllTime().map { list -> list.map { it.toTimeModel() } }
        }
    }

    override suspend fun deleteTime(time: TimeModel) {
        timeDao.deleteTime(time.toEntity())
    }

    override suspend fun insertTime(time: TimeModel) {
        timeDao.insertTime(time.toEntity())
    }
}