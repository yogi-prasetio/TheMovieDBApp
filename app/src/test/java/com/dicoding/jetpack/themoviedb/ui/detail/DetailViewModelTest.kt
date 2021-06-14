package com.dicoding.jetpack.themoviedb.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movie_id = dummyMovie.movie_id
    private val dummyTvShow = DataDummy.generateDummyTvshow()[0]
    private val tvShow_id = dummyTvShow.tvShow_id

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<MoviesEntity>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun testGetMovieDetail() {
        val movieDummy = MutableLiveData<MoviesEntity>()
        movieDummy.value = dummyMovie

        `when`(movieRepository.getMovieDetail(movie_id!!)).thenReturn(movieDummy)
        val movieData = movie_id?.let { viewModel.getMovieDetail(it).value }

        Assert.assertNotNull(movieData)
        assertEquals(dummyMovie.id, movieData?.id)
        assertEquals(dummyMovie.movie_id, movieData?.movie_id)
        assertEquals(dummyMovie.poster_path, movieData?.poster_path)
        assertEquals(dummyMovie.title, movieData?.title)
        assertEquals(dummyMovie.release_date, movieData?.release_date)
        assertEquals(dummyMovie.vote_average, movieData?.vote_average)
        assertEquals(dummyMovie.overview, movieData?.overview)

        viewModel.getMovieDetail(movie_id).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun testGetTvShowDetail() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dummyTvShow

        `when`(movieRepository.getTvShowDetail(tvShow_id)).thenReturn(tvShowDummy)
        val tvShowData = viewModel.getTvShowDetail(tvShow_id).value

        Assert.assertNotNull(tvShowData)
        assertEquals(dummyTvShow.id, tvShowData?.id)
        assertEquals(dummyTvShow.tvShow_id, tvShowData?.tvShow_id)
        assertEquals(dummyTvShow.poster_path, tvShowData?.poster_path)
        assertEquals(dummyTvShow.name, tvShowData?.name)
        assertEquals(dummyTvShow.first_air_date, tvShowData?.first_air_date)
        assertEquals(dummyTvShow.vote_average, tvShowData?.vote_average)
        assertEquals(dummyTvShow.overview, tvShowData?.overview)

        viewModel.getTvShowDetail(tvShow_id).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}