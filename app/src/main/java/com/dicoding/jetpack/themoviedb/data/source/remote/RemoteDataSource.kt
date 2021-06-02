package com.dicoding.jetpack.themoviedb.data.source.remote

import android.app.Service
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.jetpack.themoviedb.data.api.Api
import com.dicoding.jetpack.themoviedb.data.source.remote.response.MoviesResponse
import com.dicoding.jetpack.themoviedb.data.source.remote.response.TvShowResponse
import com.dicoding.jetpack.themoviedb.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val movieApi: Api) {

    fun getPopularMovie(): LiveData<ApiResponse<List<MoviesResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MoviesResponse>>>()
        CoroutineScope((IO)).launch {
            try {
                val response = movieApi.getPopularMovies().await()
                resultMovie.postValue((ApiResponse.success(response.results)))
            } catch (ex: IOException) {
                ex.printStackTrace()
                resultMovie.postValue(
                    ApiResponse.error(
                        ex.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovie
    }

    fun getPopularTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope((IO)).launch {
            try {
                val response = movieApi.getPopularTv().await()
                resultTvShow.postValue((ApiResponse.success(response.results)))
            } catch (ex: IOException) {
                ex.printStackTrace()
                resultTvShow.postValue(
                    ApiResponse.error(
                        ex.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShow
    }
}