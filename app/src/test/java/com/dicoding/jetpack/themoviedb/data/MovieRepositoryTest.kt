package com.dicoding.jetpack.themoviedb.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.jetpack.themoviedb.data.source.local.LocalDataSource
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.data.source.remote.RemoteDataSource
import com.dicoding.jetpack.themoviedb.utils.DataDummy
import com.dicoding.jetpack.themoviedb.utils.LiveDataTestUtil
import com.dicoding.jetpack.themoviedb.utils.PagedListUtil
import com.dicoding.jetpack.themoviedb.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote, local)

    private val listMovie = DataDummy.generateDummyMovies()
    private val movie = DataDummy.generateDummyMovies()[0]
    private val listTvShow = DataDummy.generateDummyTvshow()
    private val tvShow = DataDummy.generateDummyTvshow()[0]

    @Test
    fun testGetPopularMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        movieRepository.getPopularMovie()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun testGetPopularTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getPopularTvShow()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun testGetFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun testGetFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTvShows()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getFavoriteTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun testGetMovieDetail() {
        val dummyMovie = MutableLiveData<MoviesEntity>()
        dummyMovie.value = movie
        `when`(local.getDetailMovie(movie.movie_id!!)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movie.movie_id!!))
        verify(local).getDetailMovie(movie.movie_id!!)
        assertNotNull(data)
        assertEquals(movie.movie_id, data.movie_id)
    }

    @Test
    fun testGetTvShowDetail() {
        val dummyMovie = MutableLiveData<TvShowEntity>()
        dummyMovie.value = tvShow
        `when`(local.getDetailTvShow(tvShow.tvShow_id)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(movieRepository.getTvShowDetail(tvShow.tvShow_id))
        verify(local).getDetailTvShow(tvShow.tvShow_id)
        assertNotNull(data)
        assertEquals(tvShow.tvShow_id, data.tvShow_id)
    }
}