package com.dicoding.jetpack.themoviedb.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.themoviedb.databinding.FragmentMoviesBinding
import com.dicoding.jetpack.themoviedb.ui.home.MainViewModel
import com.dicoding.jetpack.themoviedb.ui.tv_show.TvShowAdapter
import com.dicoding.jetpack.themoviedb.utils.Status
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesFragment : DaggerFragment() {
    private var frgmntbinding: FragmentMoviesBinding? = null
    private val binding get() = frgmntbinding!!
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        frgmntbinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return frgmntbinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        activity?.let { setupViewModel(it) }
        observeListMovies()
    }

    private fun setupViewModel(fragmentActivity: FragmentActivity) {
        viewModel = ViewModelProvider(fragmentActivity, viewModelFactory)[MainViewModel::class.java]
    }

    private fun observeListMovies() {
        viewModel.getPopularMovies().observe(viewLifecycleOwner, { listMovies ->
            if (listMovies != null) {
                when (listMovies.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> {
                        showLoading(false)
                        binding.rvMovie.adapter?.let { adapter ->
                            when (adapter) {
                                is MoviesAdapter -> {
                                    adapter.submitList(listMovies.data)
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Failed to load data!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesAdapter()
        }
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}