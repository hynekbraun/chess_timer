package com.hynekbraun.chesstimer.data.local

import androidx.room.*

@Dao

interface TimeDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTime(entity: TimeEntity)

    @Query("SELECT * FROM chess_time")
    fun observeAllTime(): List<TimeEntity>

    @Delete
    suspend fun deleteTime(time: TimeEntity)
}