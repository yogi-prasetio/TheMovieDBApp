package com.dicoding.jetpack.themoviedb.data.api

import com.dicoding.jetpack.themoviedb.BuildConfig
import com.dicoding.jetpack.themoviedb.data.source.remote.response.ContentResponse
import com.dicoding.jetpack.themoviedb.data.source.remote.response.MoviesResponse
import com.dicoding.jetpack.themoviedb.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Call<ContentResponse<MoviesResponse>>

    @GET("tv/popular")
    fun getPopularTv(
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Call<ContentResponse<TvShowResponse>>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Call<MoviesResponse>

    @GET("tv/{tv_id}")
    fun getTvDetail(
        @Path("tv_id") tv_id: Int,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Call<TvShowResponse>
}