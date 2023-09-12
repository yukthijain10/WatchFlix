package com.example.watchflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Retrofithelper
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import com.example.watchflix.repository.mainrepointerface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class CustomViewModel(
    val repository:mainrepointerface
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
            val result = repository.getPopular()
            if (result.isSuccessful) {
                val popresponse= result.body()
                if(popresponse!=null){
                    popular.value = popresponse.results
                }
            }
        }
    }



    fun getdataFromTopRatedApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getTopRated()
            // val topresponse = result.body()
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


