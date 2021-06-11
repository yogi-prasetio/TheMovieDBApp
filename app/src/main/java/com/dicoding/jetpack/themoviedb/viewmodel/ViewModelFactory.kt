package com.dicoding.jetpack.themoviedb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.jetpack.themoviedb.data.MovieRepository
import com.dicoding.jetpack.themoviedb.ui.detail.DetailViewModel
import com.dicoding.jetpack.themoviedb.ui.favorite.FavoriteViewModel
import com.dicoding.jetpack.themoviedb.ui.home.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val mRepository: MovieRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(mRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}