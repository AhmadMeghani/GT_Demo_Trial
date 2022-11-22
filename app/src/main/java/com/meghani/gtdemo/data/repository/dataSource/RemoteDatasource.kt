package com.meghani.gtdemo.data.repository.dataSource

import com.meghani.gtdemo.data.model.APIResponse
import retrofit2.Response

interface RemoteDatasource {
    suspend fun getData(): Response<APIResponse>
}