package com.dicoding.jetpack.themoviedb.ui.tv_show

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
import com.dicoding.jetpack.themoviedb.data.source.local.entity.TvShowEntity
import com.dicoding.jetpack.themoviedb.databinding.ItemsListBinding
import com.dicoding.jetpack.themoviedb.ui.detail.DetailActivity
import com.dicoding.jetpack.themoviedb.utils.Resource

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.TvViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val BASE_URL = "https://image.tmdb.org/t/p/original"
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShow_id == newItem.tvShow_id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemsTvBinding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemsTvBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val listTv = getItem(position)
        if (listTv != null) {
            holder.bind(listTv)
        }
    }

    class TvViewHolder(private val binding: ItemsListBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("WrongConstant")
        fun bind(data: TvShowEntity) {
            with(binding) {
                val detail = "Tv Show"
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tvItemDescription.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
                }
                tvItemTitle.text = data.name
                tvItemDescription.text = data.overview
                 itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV_SHOW, data.tvShow_id)
                    intent.putExtra(DetailActivity.EXTRA_DATA, detail)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(BASE_URL+data.poster_path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }
}