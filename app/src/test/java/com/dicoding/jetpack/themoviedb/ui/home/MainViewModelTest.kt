package com.dicoding.jetpack.themoviedb.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.utils.Resource
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<PagedList<MoviesEntity>>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var moviePagedList: PagedList<MoviesEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = MainViewModel(movieRepository)
    }

    @Test
    fun testGetPopularMovies() {
        val dummyMovie = Resource.success(moviePagedList)
        `when`(dummyMovie.data?.size).thenReturn(10)
        val movie = MutableLiveData<Resource<PagedList<MoviesEntity>>>()
        movie.value = dummyMovie

        `when`(movieRepository.getPopularMovie()).thenReturn(movie)
        val movieEntity = viewModel.getPopularMovies().value?.data
        verify(movieRepository).getPopularMovie()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(10, movieEntity?.size)

        viewModel.getPopularMovies().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun testGetPopularTvShows() {
        val dummyTvShow = Resource.success(tvShowPagedList)
        `when`(dummyTvShow.data?.size).thenReturn(10)
        val tvShow = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getPopularTvShow()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getPopularTvShows().value?.data
        verify(movieRepository).getPopularTvShow()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(10, tvShowEntity?.size)

        viewModel.getPopularTvShows().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}