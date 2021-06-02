package com.dicoding.jetpack.themoviedb.di

import com.dicoding.jetpack.themoviedb.BuildConfig
import com.dicoding.jetpack.themoviedb.data.api.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object{
        @Singleton
        @Provides
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().apply {
            connectTimeout(20, TimeUnit.SECONDS)
            readTimeout(20, TimeUnit.SECONDS)
            writeTimeout(20, TimeUnit.SECONDS)
        }.build()

        @Singleton
        @Provides
        fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().apply {
            baseUrl(BuildConfig.BASE_URL)
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }.build()

        @Provides
        fun provideMovieApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
    }
}