package com.meghani.gtdemo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meghani.gtdemo.domain.usecases.GetChannelsUseCase
import com.meghani.gtdemo.domain.usecases.GetSocialsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val getChannelsUseCase: GetChannelsUseCase,
    private val getSocialsUseCase: GetSocialsUseCase
) : ViewModel() {

    fun getSocials() = liveData {
        getSocialsUseCase.execute().collect{
            emit(it)
        }
    }

    fun getChannels() = liveData {
        getChannelsUseCase.execute().collect{
            emit(it)
        }
    }
}