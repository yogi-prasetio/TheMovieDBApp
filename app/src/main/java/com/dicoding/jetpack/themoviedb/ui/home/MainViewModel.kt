package com.dicoding.jetpack.themoviedb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.utils.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor (private val mRepository: MovieRepository) : ViewModel() {

    fun getPopularMovies(): LiveData<Resource<PagedList<MoviesEntity>>> = mRepository.getPopularMovie()

    fun getPopularTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = mRepository.getPopularTvShow()
}