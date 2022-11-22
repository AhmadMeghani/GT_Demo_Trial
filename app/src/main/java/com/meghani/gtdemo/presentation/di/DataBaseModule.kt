package com.meghani.gtdemo.presentation.di

import android.app.Application
import androidx.room.Room
import com.meghani.gtdemo.data.db.AppDatabase
import com.meghani.gtdemo.data.db.DataDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "app_db")
//            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideAppDao(appDatabase: AppDatabase): DataDAO {
        return appDatabase.getDao()
    }


}