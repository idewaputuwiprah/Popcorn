package com.dicoding.popcorn.ui.favorite.movieFav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.dicoding.popcorn.data.local.MovieFavEntity
import com.dicoding.popcorn.databinding.ItemsMovieBinding
import java.lang.StringBuilder

class MovieFavAdapter : PagedListAdapter<MovieFavEntity, MovieFavAdapter.MovieFavViewHolder>(
    DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<MovieFavEntity>() {
            override fun areItemsTheSame(oldItem: MovieFavEntity, newItem: MovieFavEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieFavEntity, newItem: MovieFavEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    private lateinit var onClickListener: MovieFavCallback

    fun setOnClickListener(onClickListener: MovieFavCallback) {
        this.onClickListener = onClickListener
    }

    inner class MovieFavViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieFavEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemYears.text = movie.year
                tvRating.text = StringBuilder("${movie.rating}/10")

                Glide.with(itemView.context)
                    .load(movie.path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieFavViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holderFav: MovieFavViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holderFav.bind(movie)
            holderFav.itemView.setOnClickListener {
                onClickListener.onClick(movie)
            }
        }
    }
}