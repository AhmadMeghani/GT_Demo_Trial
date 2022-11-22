package com.meghani.gtdemo.domain.usecases

import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.domain.repo.DataRepository
import kotlinx.coroutines.flow.Flow

class GetChannelsUseCase(private val dataRepository: DataRepository) {
    fun execute(): Flow<List<Channel>> = dataRepository.getChannels()

}