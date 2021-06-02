package com.dicoding.jetpack.themoviedb.di.favorite

import com.dicoding.jetpack.themoviedb.ui.favorite.data.FavoriteMovieFragment
import com.dicoding.jetpack.themoviedb.ui.favorite.data.FavoriteTvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment() : FavoriteMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment() : FavoriteTvShowFragment
}
