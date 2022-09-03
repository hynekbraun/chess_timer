package com.hynekbraun.chesstimer.domain

import com.hynekbraun.chesstimer.data.local.TimeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTimeRepository(
        timeRepositoryModule: TimeRepositoryImp
    ): TimeRepository
}