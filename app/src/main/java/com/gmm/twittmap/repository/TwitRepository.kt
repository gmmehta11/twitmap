package com.gmm.twittmap.repository

import android.util.Log
import com.gmm.twittmap.model.Twitt
import com.gmm.twittmap.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TwitRepository {

    companion object{
        fun getTwit(token: String): Flow<Twitt> = flow {
            val response = RetrofitBuilder.api.getTwit(token)
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}