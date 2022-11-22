package com.meghani.gtdemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDAO {
    @Insert
    suspend fun insertSocials(socials: List<Social>)

    @Insert
    suspend fun insertChannels(channels: List<Channel>)

    @Query("SELECT * FROM socials")
    fun getSocials(): Flow<List<Social>>

    @Query("SELECT * FROM channels")
    fun getChannels(): Flow<List<Channel>>
}