package com.dicoding.jetpack.themoviedb.di

import android.app.Application
import android.app.Service
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.data.api.Api
import com.dicoding.jetpack.themoviedb.data.source.local.LocalDataSource
import com.dicoding.jetpack.themoviedb.data.source.local.roomdatabase.MovieDao
import com.dicoding.jetpack.themoviedb.data.source.local.roomdatabase.MovieDatabase
import com.dicoding.jetpack.themoviedb.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object{
        @Singleton
        @Provides
        fun provideMovieDatabase(application: Application): MovieDatabase = MovieDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao = movieDatabase.movieDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(movieDao: MovieDao): LocalDataSource = LocalDataSource(movieDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: Api): RemoteDataSource = RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideMovieRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): MovieRepository = MovieRepository(localDataSource, remoteDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(repository: MovieRepository): ViewModelFactory = ViewModelFactory(repository)
    }

}