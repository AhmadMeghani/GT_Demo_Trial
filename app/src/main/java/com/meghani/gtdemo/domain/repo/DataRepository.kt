package com.meghani.gtdemo.domain.repo

import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getSocials(): Flow<List<Social>>
    fun getChannels(): Flow<List<Channel>>

    suspend fun updateSocials(): List<Social>
    suspend fun updateChannels(): List<Channel>
}