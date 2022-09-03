package com.hynekbraun.chesstimer.data.local.timedatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hynekbraun.chesstimer.data.local.timedatabase.TimeDatabase.Companion.DATABASE_VERSION

@Database(
    entities = [TimeEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class TimeDatabase: RoomDatabase() {

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "time_database"
    }

    abstract fun getTimeDao(): TimeDao
}