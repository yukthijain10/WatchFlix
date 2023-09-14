package com.example.watchflix.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import com.example.watchflix.network.repository.mainrepointerface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class CustomViewModel(
    val repository: mainrepointerface
) : ViewModel() {
    val popular = MutableStateFlow<Response<Popular>?>(null)
    val toprated = MutableStateFlow<Response<Toprated>?>(null)
    val upcoming = MutableStateFlow<Response<Upcoming>?>(null)
    val popularlist: StateFlow<Response<Popular>?> = popular
    val toplist: StateFlow<Response<Toprated>?> = toprated
    val uplist: StateFlow<Response<Upcoming>?> = upcoming
    init{
        getdataFromPopularApi()
        getdataFromTopRatedApi()
        getdataFromUpcomingApi()
    }
    fun getdataFromPopularApi() {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val result = repository.getPopular()
                Log.d("API check",result.toString())
                if (result.isSuccessful) {
                    val popresponse= result
                    if(popresponse!=null){
                        popular.value = popresponse
                    }
                }
            }
            catch(e: Exception){
                Log.d("API check",e.toString())
            }
        }
    }
    fun getdataFromTopRatedApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getTopRated()
            if (result.isSuccessful) {
                val topresponse = result
                if (topresponse != null) {
                    toprated.value = topresponse
                }
            }
        }
    }
    fun getdataFromUpcomingApi() {
            viewModelScope.launch(Dispatchers.IO) {
                val result = repository.getUpComing()
                if (result.isSuccessful) {
                    val upcoming_movies = result
                    if (upcoming_movies != null)
                        upcoming.value = upcoming_movies
                }
            }
        }
    }


