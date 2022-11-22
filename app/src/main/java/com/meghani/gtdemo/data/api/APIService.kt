package com.meghani.gtdemo.data.api

import com.meghani.gtdemo.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("channels-socials.json")
    suspend fun getData(): Response<APIResponse>
}