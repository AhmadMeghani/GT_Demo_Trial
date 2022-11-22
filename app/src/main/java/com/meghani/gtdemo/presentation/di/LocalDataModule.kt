package com.meghani.gtdemo.presentation.di

import com.meghani.gtdemo.data.db.DataDAO
import com.meghani.gtdemo.data.repository.dataSource.LocalDatasource
import com.meghani.gtdemo.data.repository.dataSourceImpl.LocalDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(dataDAO: DataDAO): LocalDatasource {
        return LocalDatasourceImpl(dataDAO)
    }

}













