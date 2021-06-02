package com.dicoding.jetpack.themoviedb.di

import com.dicoding.jetpack.themoviedb.ui.SplashActivity
import com.dicoding.jetpack.themoviedb.ui.detail.DetailActivity
import com.dicoding.jetpack.themoviedb.ui.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [MainFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity
}