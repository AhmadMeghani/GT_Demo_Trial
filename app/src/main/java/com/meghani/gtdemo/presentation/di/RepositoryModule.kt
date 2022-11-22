package com.meghani.gtdemo.presentation.di

import com.meghani.gtdemo.data.repository.DataRepositoryImpl
import com.meghani.gtdemo.data.repository.dataSource.LocalDatasource
import com.meghani.gtdemo.data.repository.dataSource.RemoteDatasource
import com.meghani.gtdemo.domain.repo.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(
        remoteDatasource: RemoteDatasource,
        localDatasource: LocalDatasource
    ): DataRepository {
        return DataRepositoryImpl(
            remoteDatasource,
            localDatasource
        )
    }

}














