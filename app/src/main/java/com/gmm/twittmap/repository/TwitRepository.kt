package com.gmm.twittmap.repository

import com.gmm.twittmap.model.Twitt
import com.gmm.twittmap.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TwitRepository {

    companion object{
        fun getTwit(): Flow<List<Twitt>> = flow {
            val response = RetrofitBuilder.api.getTwit()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}