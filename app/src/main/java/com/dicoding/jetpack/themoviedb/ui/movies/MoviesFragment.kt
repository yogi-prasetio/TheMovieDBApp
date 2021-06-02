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
import com.dicoding.jetpack.themoviedb.utils.Status
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesFragment  : DaggerFragment() {
    private var frgmntmoviesbinding: FragmentMoviesBinding? = null
    private val binding get() = frgmntmoviesbinding!!
    private lateinit var viewModel: MainViewModel

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        frgmntmoviesbinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return frgmntmoviesbinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            setupViewModel(it)
            val moviesAdapter = MoviesAdapter()

            viewModel.getPopularMovies().observe(viewLifecycleOwner, {
                if (it!=null) {
                    when(it.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            showLoading(false)
                            moviesAdapter.submitList(it.data)
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(context, "Failed to load data!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            binding.apply {
                rvMovie.layoutManager = LinearLayoutManager(context)
                rvMovie.setHasFixedSize(true)
                rvMovie.adapter = moviesAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntmoviesbinding = null
    }

    private fun setupViewModel(fragmentActivity: FragmentActivity) {
        viewModel = ViewModelProvider(fragmentActivity, viewModelFactory)[MainViewModel::class.java]
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}