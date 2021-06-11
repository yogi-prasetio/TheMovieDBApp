package com.dicoding.jetpack.themoviedb.di

import com.dicoding.jetpack.themoviedb.di.favorite.FavoriteFragmentBuilderModule
import com.dicoding.jetpack.themoviedb.ui.detail.DetailActivity
import com.dicoding.jetpack.themoviedb.ui.favorite.FavoriteFragment
import com.dicoding.jetpack.themoviedb.ui.home.MainActivity
import com.dicoding.jetpack.themoviedb.ui.movies.MoviesFragment
import com.dicoding.jetpack.themoviedb.ui.tv_show.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragmet(): TvShowFragment

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuilderModule::class])
    abstract fun contributeFavoriteFragmet(): FavoriteFragment
}