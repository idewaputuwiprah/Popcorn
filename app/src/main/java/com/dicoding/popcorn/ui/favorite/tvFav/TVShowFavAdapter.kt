package com.dicoding.popcorn.ui.favorite.tvFav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.dicoding.popcorn.data.local.TVShowFavEntity
import com.dicoding.popcorn.databinding.ItemsTvshowsBinding
import java.lang.StringBuilder

class TVShowFavAdapter : PagedListAdapter<TVShowFavEntity, TVShowFavAdapter.TVShowsFavViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowFavEntity>() {
            override fun areItemsTheSame(oldItem: TVShowFavEntity, newItem: TVShowFavEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TVShowFavEntity, newItem: TVShowFavEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    private lateinit var onClickListener: TVShowFavCallback

    fun setOnClickListener(onClickListener: TVShowFavCallback) {
        this.onClickListener = onClickListener
    }

    class TVShowsFavViewHolder(private val binding: ItemsTvshowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: TVShowFavEntity) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemYears.text = show.year
                tvRating.text = StringBuilder("${show.rating}/10")

                Glide.with(itemView.context)
                        .load(show.path)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsFavViewHolder {
        val itemsTvShowsBinding = ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowsFavViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holderFav: TVShowsFavViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holderFav.bind(tvShow)
            holderFav.itemView.setOnClickListener {
                onClickListener.onClick(tvShow)
            }
        }
    }
}