package com.hynekbraun.chesstimer.data.local

import com.hynekbraun.chesstimer.domain.TimeModel
import com.hynekbraun.chesstimer.domain.TimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class TimeRepositoryImp
@Inject constructor(timeDao: TimeDao) : TimeRepository {
    override fun getTime(): Flow<List<TimeModel>> {
        return flow {

        }
    }

    override suspend fun deleteTime(time: TimeModel) {
    }

    override suspend fun insertTime(time: TimeModel) {
    }
}