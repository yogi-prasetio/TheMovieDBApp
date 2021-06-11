 package com.dicoding.jetpack.themoviedb.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dicoding.jetpack.themoviedb.R
import com.dicoding.jetpack.themoviedb.databinding.ActivityMainBinding
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

 class MainActivity : DaggerAppCompatActivity() {
     private var _activityMainBinding: ActivityMainBinding? = null
     private val binding get() = _activityMainBinding
     private lateinit var viewModel: MainViewModel

     @Inject
     lateinit var factory: ViewModelFactory

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding?.root)

         setSupportActionBar(binding?.mainToolbar)
         supportActionBar?.elevation = 0f
         viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

         val navController = findNavController(R.id.list_view_fragment)
         val appBarConfiguration = AppBarConfiguration.Builder(
             R.id.movie_navigation,
             R.id.tv_show_navigation,
             R.id.favorite_navigation
         ).build()

         setupActionBarWithNavController(this, navController, appBarConfiguration)
         binding?.bottomNavigation?.setupWithNavController(navController)
     }

     override fun onDestroy() {
         super.onDestroy()
         _activityMainBinding = null
     }
}