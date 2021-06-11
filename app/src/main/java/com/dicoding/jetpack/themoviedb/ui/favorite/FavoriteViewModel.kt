package com.dicoding.jetpack.themoviedb.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MoviesEntity>> = movieRepository.getFavoriteMovies()

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = movieRepository.getFavoriteTvShows()
}