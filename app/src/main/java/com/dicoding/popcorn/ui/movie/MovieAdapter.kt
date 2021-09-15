package com.dicoding.popcorn.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.popcorn.databinding.ItemsMovieBinding
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.utils.loadImage
import com.idputuwiprah.core.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var onClickListener: ItemCallback
    private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.movieId == newItem.movieId
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var listMovies : List<Movie>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    fun setOnClickListener(onClickListener: ItemCallback) {
        this.onClickListener = onClickListener
    }

    class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemYears.text = movie.year
                tvRating.text = StringBuilder("${movie.rating}/10")
                imgPoster.loadImage(movie.path)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovies[position])
        holder.itemView.setOnClickListener {
            onClickListener.onClick(listMovies[position])
        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
}