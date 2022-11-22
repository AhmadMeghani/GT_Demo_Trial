package com.meghani.gtdemo.data.repository

import android.util.Log
import com.meghani.gtdemo.data.model.Body
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
import com.meghani.gtdemo.data.repository.dataSource.LocalDatasource
import com.meghani.gtdemo.data.repository.dataSource.RemoteDatasource
import com.meghani.gtdemo.domain.repo.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataRepositoryImpl(
    private val remoteDatasource: RemoteDatasource, private val localDatasource: LocalDatasource
) : DataRepository {

    private fun getChannelsFromDB() = flow {
        localDatasource.getChannels().collect {
            if (it.isNotEmpty()) {
                emit(it)
            } else {
                val apiData = getDataFromAPI()
                emit(apiData.channels)
            }
        }
    }

    private fun getSocialsFromDB() = flow {
        localDatasource.getSocials().collect {
            if (it.isNotEmpty()) {
                emit(it)
            } else {
                val apiData = getDataFromAPI()
                emit(apiData.socials)
            }
        }
    }

    private suspend fun getDataFromAPI(): Body {
        lateinit var body: Body

        try {
            val response = remoteDatasource.getData()
            val responseBody = response.body()

            if (responseBody != null) {
                body = responseBody.body
                localDatasource.saveSocials(body.socials)
                localDatasource.saveChannels(body.channels)
            }
        } catch (e: Exception) {
            Log.e("GT_DEMO", "getDataFromAPI: ${e.message}")
        }

        return body
    }

    override fun getSocials(): Flow<List<Social>> {
        return getSocialsFromDB()
    }

    override fun getChannels(): Flow<List<Channel>> {
        return getChannelsFromDB()
    }

    override suspend fun updateSocials(): List<Social> {
        TODO("Not yet implemented")
    }

    override suspend fun updateChannels(): List<Channel> {
        TODO("Not yet implemented")
    }

}