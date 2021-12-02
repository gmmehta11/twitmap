package com.gmm.twittmap.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit:Retrofit by  lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl.baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}