package com.meghani.gtdemo.data.repository.dataSourceImpl

import com.meghani.gtdemo.data.db.DataDAO
import com.meghani.gtdemo.data.model.Channel
import com.meghani.gtdemo.data.model.Social
import com.meghani.gtdemo.data.repository.dataSource.LocalDatasource
import kotlinx.coroutines.flow.Flow

class LocalDatasourceImpl(private val dao: DataDAO) : LocalDatasource {
    override suspend fun saveSocials(socials: List<Social>) {
        dao.insertSocials(socials)
    }

    override suspend fun saveChannels(channel: List<Channel>) {
        dao.insertChannels(channel)
    }

    override fun getSocials(): Flow<List<Social>> = dao.getSocials()


    override fun getChannels(): Flow<List<Channel>> = dao.getChannels()
}