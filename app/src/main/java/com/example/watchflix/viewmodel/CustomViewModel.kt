package com.example.watchflix.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX
import com.example.watchflix.network.repository.mainrepointerface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class CustomViewModel(
    val repository: mainrepointerface
) : ViewModel() {
    val popular = MutableStateFlow<List<ResultX>?>(null)
    val toprated = MutableStateFlow<List<Result>?>(null)
    val upcoming = MutableStateFlow<List<ResultXX>?>(null)
    val popularlist: StateFlow<List<ResultX>?> = popular
    val toplist: StateFlow<List<Result>?> = toprated
    val uplist: StateFlow<List<ResultXX>?> = upcoming
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
                    val popresponse= result.body()
                    if(popresponse!=null){
                        popular.value = popresponse.results
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
                val topresponse = result.body()
                if (topresponse != null) {
                    toprated.value = topresponse.results
                }
            }
        }
    }
    fun getdataFromUpcomingApi() {
            viewModelScope.launch(Dispatchers.IO) {
                val result = repository.getUpComing()
                if (result.isSuccessful) {
                    val upcoming_movies = result.body()
                    if (upcoming_movies != null)
                        upcoming.value = upcoming_movies.results
                }
            }
        }
    }


