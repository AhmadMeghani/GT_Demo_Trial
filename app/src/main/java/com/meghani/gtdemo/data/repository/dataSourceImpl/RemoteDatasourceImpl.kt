package com.meghani.gtdemo.data.repository.dataSourceImpl

import com.meghani.gtdemo.data.api.APIService
import com.meghani.gtdemo.data.model.APIResponse
import com.meghani.gtdemo.data.repository.dataSource.RemoteDatasource
import retrofit2.Response

class RemoteDatasourceImpl(private val apiService: APIService) : RemoteDatasource {
    override suspend fun getData(): Response<APIResponse> = apiService.getData()

}