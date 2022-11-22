package com.meghani.gtdemo.domain.usecases

import com.meghani.gtdemo.data.model.Social
import com.meghani.gtdemo.domain.repo.DataRepository
import kotlinx.coroutines.flow.Flow

class GetSocialsUseCase(private val dataRepository: DataRepository) {
    fun execute(): Flow<List<Social>> = dataRepository.getSocials()
}