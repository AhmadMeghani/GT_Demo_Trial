package com.meghani.gtdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social

@Database(entities = [Social::class, Channel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): DataDAO
}