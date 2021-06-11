package com.dicoding.jetpack.themoviedb.ui.favorite.data

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.themoviedb.databinding.FavoriteTvShowFragmentBinding
import com.dicoding.jetpack.themoviedb.ui.favorite.FavoriteViewModel
import com.dicoding.jetpack.themoviedb.ui.movies.MoviesAdapter
import com.dicoding.jetpack.themoviedb.ui.tv_show.TvShowAdapter
import com.dicoding.jetpack.themoviedb.utils.Status
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteTvShowFragment : DaggerFragment() {
    private var frgmntbinding: FavoriteTvShowFragmentBinding? = null
    private val binding get() = frgmntbinding!!
    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        frgmntbinding = FavoriteTvShowFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntbinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            rvFavoriteTvShows.layoutManager = LinearLayoutManager(context)
            rvFavoriteTvShows.setHasFixedSize(true)
            rvFavoriteTvShows.adapter = TvShowAdapter()
        }

        parentFragment?.let {
            viewModel = ViewModelProvider(it, viewModelFactory)[FavoriteViewModel::class.java]
        }

        activity?.let {
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, {
                if (it!=null) {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.apply {
                        rvFavoriteTvShows.adapter?.let {adapter ->
                            when (adapter) {
                                is TvShowAdapter -> {
                                    if (it.isNullOrEmpty()){
                                        rvFavoriteTvShows.visibility = View.GONE
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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntbinding = null
    }

}