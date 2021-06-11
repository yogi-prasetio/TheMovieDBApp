package com.dicoding.jetpack.themoviedb.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.dicoding.jetpack.themoviedb.R
import com.dicoding.jetpack.themoviedb.ui.home.MainActivity
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500 )
    }
}