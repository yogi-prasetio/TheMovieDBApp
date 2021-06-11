package com.dicoding.jetpack.themoviedb.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.data.source.local.roomdatabase.MovieDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getMovies(): DataSource.Factory<Int, MoviesEntity> = movieDao.getMovies()

    fun getFavoriteMovies() : DataSource.Factory<Int, MoviesEntity> = movieDao.getFavoriteMovies()

    fun getDetailMovie(movieId: Int) : LiveData<MoviesEntity> = movieDao.getDetailMovieById(movieId)

    fun insertMovies(movies: List<MoviesEntity>) {movieDao.insertMovies(movies)}

    fun setFavoriteMovie(movie : MoviesEntity) {
        movie.isFavorite = !movie.isFavorite
        movieDao.updateMovies(movie)
    }

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = movieDao.getTvShows()

    fun getFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = movieDao.getFavoriteTvShows()

    fun getDetailTvShow(tvShow_id: Int) : LiveData<TvShowEntity> = movieDao.getDetailTvShowById(tvShow_id)

    fun insertTvShow(tvShow: List<TvShowEntity>) {movieDao.insertTvShow(tvShow)}

    fun setFavoriteTvShow(tvShow : TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        movieDao.updateTvShow(tvShow)
    }
}