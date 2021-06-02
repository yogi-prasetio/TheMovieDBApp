package com.dicoding.jetpack.themoviedb.data.source.local.roomdatabase

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity

@Dao
interface MovieDao {
    //Movies Table
    @Query("SELECT * FROM favorite_movie")
    fun getMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM favorite_movie where isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM favorite_movie WHERE movie_id = :movie_id")
    fun getDetailMovieById(movie_id: Int) : LiveData<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MoviesEntity::class)
    fun insertMovies(movies: List<MoviesEntity>)

    @Update(entity = MoviesEntity::class)
    fun updateMovies(movies: MoviesEntity)

    //TvShow Table
    @Query("SELECT * FROM favorite_tv_show")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM favorite_tv_show where isFavorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM favorite_tv_show WHERE tvShow_id = :tvShow_id")
    fun getDetailTvShowById(tvShow_id: Int) : LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowEntity::class)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update(entity = TvShowEntity::class)
    fun updateTvShow(tvShow: TvShowEntity)
}