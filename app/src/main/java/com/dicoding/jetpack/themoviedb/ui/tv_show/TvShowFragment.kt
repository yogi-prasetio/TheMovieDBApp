package com.dicoding.jetpack.themoviedb.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpack.themoviedb.databinding.FragmentTvShowBinding
import com.dicoding.jetpack.themoviedb.ui.home.MainViewModel
import com.dicoding.jetpack.themoviedb.utils.Status
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TvShowFragment : DaggerFragment() {
    private var frgmntbinding: FragmentTvShowBinding? = null
    private val binding get() = frgmntbinding!!
    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        frgmntbinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return frgmntbinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
            val tvAdapter = TvShowAdapter()

            viewModel.getPopularTvShows().observe(viewLifecycleOwner, {
                if (it!=null) {
                    when(it.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            showLoading(false)
                            tvAdapter.submitList(it.data)
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(context, "Failed to load data!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            binding.apply {
                rvTvShow.layoutManager = LinearLayoutManager(context)
                rvTvShow.setHasFixedSize(true)
                rvTvShow.adapter = tvAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntbinding = null
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}