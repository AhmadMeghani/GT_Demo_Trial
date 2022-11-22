package com.meghani.gtdemo.presentation.di

import com.meghani.gtdemo.data.api.APIService
import com.meghani.gtdemo.data.repository.dataSource.RemoteDatasource
import com.meghani.gtdemo.data.repository.dataSourceImpl.RemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        apiService: APIService
    ): RemoteDatasource {
        return RemoteDatasourceImpl(apiService)
    }

}












