package com.dicoding.jetpack.themoviedb.ui.movies

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpack.themoviedb.R
import com.dicoding.jetpack.themoviedb.data.source.local.entity.MoviesEntity
import com.dicoding.jetpack.themoviedb.databinding.ItemsListBinding
import com.dicoding.jetpack.themoviedb.ui.detail.DetailActivity

class MoviesAdapter: PagedListAdapter<MoviesEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val BASE_URL = "https://image.tmdb.org/t/p/w500"
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<MoviesEntity>(){
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.movie_id == newItem.movie_id
            }

            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val data = getItem(position)
        if(data != null){
            holder.bind(data)
        }
    }

    class MoviesViewHolder (private val binding: ItemsListBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("WrongConstant")
        fun bind(movies: MoviesEntity) {
            with(binding) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tvItemDescription.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
                }
                tvItemTitle.text = movies.title
                tvItemDescription.text = movies.overview

                Glide.with(itemView.context)
                    .load(BASE_URL + movies.poster_path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val detail = "Movies"
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIES, movies.id)
                    intent.putExtra(DetailActivity.EXTRA_DATA, detail)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}