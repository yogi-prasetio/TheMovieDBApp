package com.dicoding.jetpack.themoviedb.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.jetpack.themoviedb.utils.Resource
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity

interface MovieDataSource {
    fun getPopularMovie(): LiveData<Resource<PagedList<MoviesEntity>>>

    fun getPopularTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getFavoriteMovies(): LiveData<PagedList<MoviesEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun getMovieDetail(movieId: Int): LiveData<MoviesEntity>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity>

    fun setFavoriteMovie(movie: MoviesEntity)

    fun setFavoriteTvShow(tvShow: TvShowEntity)
}