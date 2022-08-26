package com.hynekbraun.chesstimer.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMoviesDatabase(@ApplicationContext context: Context): TimeDatabase =
        Room.databaseBuilder(
            context,
            TimeDatabase::class.java,
            TimeDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMoviesDao(database: TimeDatabase): TimeDao = database.getTimeDao()
}
