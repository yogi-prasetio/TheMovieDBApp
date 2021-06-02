package com.dicoding.jetpack.themoviedb.ui.detail

import android.annotation.SuppressLint
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

    @Inject
    lateinit var factory: ViewModelFactory

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_DATA = "extra_data"
        const val BASE_URL = "https://image.tmdb.org/t/p/original"
    }

    @SuppressLint("WrongConstant", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_MOVIES, 0)
        val idTv = intent.getIntExtra(EXTRA_TV_SHOW, 0)
        val data = intent.getStringExtra(EXTRA_DATA)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.tvItemDescription.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }

        if (data?.equals("Movies") == true) {
            detailMovieObserve(id)
        } else if (data?.equals("Tv Show") == true) {
            detailTvShowObserve(idTv)
        }
        showLoading(true)
    }

    private fun detailMovieObserve(movieId: Int) {
        viewModel.getMovieDetail(movieId).observe(this, { movies ->
            val status = movies?.isFavorite
            status?.let { setStatus(it)}
//            val hour =  movies.runtime!!.div(60)
//            val minutes = movies.runtime!!.rem(60)

            if(movies != null){
                binding.apply {
                    tvItemTitle.text = movies.title
                    tvItemRelease.text = movies.release_date
                    tvItemRating.text = movies.vote_average
//                    tvItemDuration.text = "${hour}h ${minutes}m"
                    tvItemDescription.text = movies.overview

                    Glide.with(this@DetailActivity)
                            .load(BASE_URL + movies.poster_path)
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                            .into(imgPoster)
                }
                showLoading(false)

                binding.toggleFavorite.setOnClickListener {
                    setFavorite(movies, null)
                }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun detailTvShowObserve(tvShowId: Int) {
        viewModel.getTvShowDetail(tvShowId).observe(this, { tvShow ->
            val status = tvShow?.isFavorite
            status?.let { setStatus(it) }

            if (tvShow != null) {
                binding.apply {
                    tvItemTitle.text = tvShow.name
                    tvItemRelease.text = tvShow.first_air_date
                    tvItemRating.text = tvShow.vote_average
                    tvItemDuration.text = "Unknown"
                    tvItemDescription.text = tvShow.overview

                    Glide.with(this@DetailActivity)
                            .load(BASE_URL + tvShow.poster_path)
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                            .into(imgPoster)
                }
                showLoading(false)

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

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}