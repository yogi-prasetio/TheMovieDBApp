package com.dicoding.jetpack.themoviedb.ui.favorite

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dicoding.jetpack.themoviedb.databinding.FavoriteFragmentBinding
import com.dicoding.jetpack.themoviedb.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteFragment : DaggerFragment() {
    private var frgmntbinding: FavoriteFragmentBinding? = null
    private val binding get() = frgmntbinding!!

    private lateinit var viewModel: FavoriteViewModel
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frgmntbinding = FavoriteFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntbinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { setViewPager(it) }
        viewModel = ViewModelProvider(this@FavoriteFragment, factory).get(FavoriteViewModel::class.java)
    }

    private fun setViewPager(context: Context) {
        val sectionPagerAdapter = SectionPagerAdapter(context, childFragmentManager)
        binding.apply {
            favoriteViewPager.adapter = sectionPagerAdapter
            favoriteTab.setupWithViewPager(favoriteViewPager)
        }
    }
}