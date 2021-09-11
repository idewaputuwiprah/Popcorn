package com.dicoding.popcorn.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.popcorn.databinding.ItemsMovieBinding
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.utils.loadImage
import com.idputuwiprah.core.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<Movie>()
    private lateinit var onClickListener: ItemCallback

    fun setOnClickListener(onClickListener: ItemCallback) {
        this.onClickListener = onClickListener
    }

    fun setMovie(movies: List<Movie>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
        notifyDataSetChanged()
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

    override fun getItemCount(): Int = listMovies.size
}