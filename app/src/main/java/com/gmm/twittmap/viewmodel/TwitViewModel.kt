package com.gmm.twittmap.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmm.twittmap.model.Twitt
import com.gmm.twittmap.repository.TwitRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TwitViewModel : ViewModel() {
    val responseLiveData: MutableLiveData<List<Twitt>> = MutableLiveData()

    fun getTwit(){
        viewModelScope.launch {
            TwitRepository.getTwit()
                .catch {
                    e-> Log.d("TwitViewModel","getTwit: ${e.message}")
                }
                .collect {
                    response-> responseLiveData.value=response
                }
        }
    }

}