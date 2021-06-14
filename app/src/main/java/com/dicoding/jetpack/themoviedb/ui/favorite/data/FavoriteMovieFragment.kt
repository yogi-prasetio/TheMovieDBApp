package com.dicoding.jetpack.themoviedb.ui.favorite.data

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.themoviedb.R
import com.dicoding.jetpack.themoviedb.databinding.FavoriteFragmentBinding
import com.dicoding.jetpack.themoviedb.databinding.FavoriteMovieFragmentBinding
import com.dicoding.jetpack.themoviedb.databinding.FragmentMoviesBinding
import com.dicoding.jetpack.themoviedb.ui.favorite.FavoriteViewModel
import com.dicoding.jetpack.themoviedb.ui.favorite.SectionPagerAdapter
import com.dicoding.jetpack.themoviedb.ui.movies.MoviesAdapter
import com.dicoding.jetpack.themoviedb.ui.tv_show.TvShowAdapter
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteMovieFragment : DaggerFragment() {
    private var frgmntbinding: FavoriteMovieFragmentBinding? = null
    private val binding get() = frgmntbinding!!
    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frgmntbinding = FavoriteMovieFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntbinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(this, viewModelFactory)[FavoriteViewModel::class.java]
            val moviesAdapter = MoviesAdapter()

            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, {
                if (it!=null) {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.apply {
                        rvFavoriteMovies.adapter?.let {adapter ->
                            when (adapter) {
                                is MoviesAdapter -> {
                                    if (it.isNullOrEmpty()){
                                        rvFavoriteMovies.visibility = View.GONE
                                        progressBar.visibility = View.GONE
                                        dataEmpty.visibility = View.VISIBLE
                                        tvDesc.visibility = View.VISIBLE
                                    } else {
                                        progressBar.visibility = View.GONE
                                        adapter.submitList(it)
                                        adapter.notifyDataSetChanged()
                                    }
                                }
                            }
                        }
                    }
                }
            })

            binding.apply {
                rvFavoriteMovies.layoutManager = LinearLayoutManager(context)
                rvFavoriteMovies.setHasFixedSize(true)
                rvFavoriteMovies.adapter = moviesAdapter
            }
        }
    }
}