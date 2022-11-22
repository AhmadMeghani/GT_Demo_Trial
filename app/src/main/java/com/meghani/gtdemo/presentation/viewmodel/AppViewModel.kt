package com.meghani.gtdemo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
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

    var socialData: MutableLiveData<List<Social>> = MutableLiveData<List<Social>>()
    var channelData: MutableLiveData<List<Channel>> = MutableLiveData<List<Channel>>()

    fun getSocials() = liveData {
        getSocialsUseCase.execute().collect{
            socialData.postValue(it)
            emit(it)
        }
    }

    fun getChannels() = liveData {
        getChannelsUseCase.execute().collect{
            channelData.postValue(it)
            emit(it)
        }
    }
}