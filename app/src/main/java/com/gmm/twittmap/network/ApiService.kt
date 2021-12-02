package com.gmm.twittmap.network

import com.gmm.twittmap.model.Twitt
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService{

    @GET("tweets/search/recent?query=rain&max_results=100&tweet.fields=geo&expansions=geo.place_id&place.fields=geo")
    suspend fun getTwit(@Header("Authorization") token:String):Twitt

}