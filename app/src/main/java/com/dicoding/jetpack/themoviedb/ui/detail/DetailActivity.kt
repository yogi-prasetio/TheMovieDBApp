package com.dicoding.jetpack.themoviedb.ui.detail

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.themoviedb.R
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.databinding.ActivityDetailBinding
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var data: String
    private lateinit var url: String

    @Inject
    lateinit var factory: ViewModelFactory

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_DATA = "extra_data"
        const val BASE_URL = "https://image.tmdb.org/t/p/original"
    }

    @SuppressLint("WrongConstant", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_ID, 0)
        data = intent.getStringExtra(EXTRA_DATA).toString()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.tvItemDescription.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }

        if (data.equals("Movies") == true) {
            detailMovieObserve(id)
            url = "https://themoviedb.org/movie/" + id
        } else if (data.equals("Tv Show") == true) {
            detailTvShowObserve(id)
            url = "https://themoviedb.org/tv/" + id
        }
        showLoading(true)

        binding.btnViewWeb.setOnClickListener {
            val webpage: Uri = Uri.parse(url)
            Intent(Intent.ACTION_VIEW, webpage).also {
                startActivity(Intent.createChooser(it, "Open with "))
            }
        }

    }

    private fun detailMovieObserve(movieId: Int) {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Movie"

        viewModel.getMovieDetail(movieId).observe(this, { movies ->
            val status = movies?.isFavorite
            status?.let { setStatus(it)}

            if(movies != null){
                binding.apply {
                    tvItemTitle.text = movies.title
                    tvItemRelease.text = movies.release_date
                    tvItemRating.text = movies.vote_average
                    tvItemDescription.text = movies.overview

                    Glide.with(this@DetailActivity)
                            .load(BASE_URL + movies.poster_path)
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                            .into(imgPoster)
                }
                showLoading(false)

                binding.buttonShare.setOnClickListener { share() }

                binding.toggleFavorite.setOnClickListener {
                    setFavorite(movies, null)
                }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun detailTvShowObserve(tvShowId: Int) {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Tv Show"

        viewModel.getTvShowDetail(tvShowId).observe(this, { tvShow ->
            val status = tvShow?.isFavorite
            status?.let { setStatus(it) }

            if (tvShow != null) {
                binding.apply {
                    tvItemTitle.text = tvShow.name
                    tvItemRelease.text = tvShow.first_air_date
                    tvItemRating.text = tvShow.vote_average
                    tvItemDescription.text = tvShow.overview

                    Glide.with(this@DetailActivity)
                            .load(BASE_URL + tvShow.poster_path)
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                            .into(imgPoster)
                }
                showLoading(false)

                binding.buttonShare.setOnClickListener { share() }

                binding.toggleFavorite.setOnClickListener {
                    setFavorite(null, tvShow)
                }
            }
        })
    }

    private fun setFavorite(movies: MoviesEntity?, tvShow: TvShowEntity?) {
            if (movies != null) {
                if (movies.isFavorite) {
                    binding.toggleFavorite.isChecked = false
                    Toast.makeText(this, "Deleted from Favorite!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Success added to Favorite!", Toast.LENGTH_SHORT).show()
                }
                viewModel.setFavoriteMovie(movies)
            } else if (tvShow != null) {
                if (tvShow.isFavorite) {
                    binding.toggleFavorite.isChecked = false
                    Toast.makeText(this, "Deleted from Favorite!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Success added to Favorite!", Toast.LENGTH_SHORT).show()
                }
                viewModel.setFavoriteTvShow(tvShow)
            }
    }

    private fun setStatus(status: Boolean){
        binding.toggleFavorite.isChecked = status
    }

    private fun share(){
        val sendIntent = Intent()
        sendIntent.setAction(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, url)
        sendIntent.setType("text/plain")
        startActivity(Intent.createChooser(sendIntent, "Share to"))
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}