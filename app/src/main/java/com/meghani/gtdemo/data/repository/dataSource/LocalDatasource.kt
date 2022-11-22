package com.meghani.gtdemo.data.repository.dataSource

import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
import kotlinx.coroutines.flow.Flow

interface LocalDatasource {
    suspend fun saveSocials(socials: List<Social>)
    suspend fun saveChannels(channel: List<Channel>)
    fun getSocials(): Flow<List<Social>>
    fun getChannels(): Flow<List<Channel>>

}