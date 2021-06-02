package com.dicoding.jetpack.themoviedb.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val repo: MovieRepository): ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<MoviesEntity> =
            repo.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
            repo.getTvShowDetail(tvShowId)

    fun setFavoriteMovie(moviesEntity: MoviesEntity){
        repo.setFavoriteMovie(moviesEntity)
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity){
        repo.setFavoriteTvShow(tvShowEntity)
    }
}