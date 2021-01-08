package com.astromtrading.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUtils {
    constructor(){

    }

    fun getAPIService(): ApiService {
        var retrofitClient: RetrofitClient=RetrofitClient(Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build())
        return retrofitClient.getClient(ApiService.BASE_URL).create(ApiService::class.java)
    }
}