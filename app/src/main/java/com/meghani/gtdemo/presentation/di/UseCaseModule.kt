package com.meghani.gtdemo.presentation.di

import com.meghani.gtdemo.domain.repo.DataRepository
import com.meghani.gtdemo.domain.usecases.GetChannelsUseCase
import com.meghani.gtdemo.domain.usecases.GetSocialsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetChannelsUseCase(
        dataRepository: DataRepository
    ): GetChannelsUseCase {
        return GetChannelsUseCase(dataRepository)
    }

    @Singleton
    @Provides
    fun provideGetSocialsUseCase(
        dataRepository: DataRepository
    ): GetSocialsUseCase {
        return GetSocialsUseCase(dataRepository)
    }
}


















