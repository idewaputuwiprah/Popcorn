package com.dicoding.popcorn.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.popcorn.databinding.ItemsTvshowsBinding
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.utils.loadImage
import com.idputuwiprah.core.domain.model.Movie

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowsViewHolder>() {
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

    var listTVShows : List<Movie>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    fun setOnClickListener(onClickListener: ItemCallback) {
        this.onClickListener = onClickListener
    }

    class TVShowsViewHolder(private val binding: ItemsTvshowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Movie) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemYears.text = show.year
                tvRating.text = StringBuilder("${show.rating}/10")
                imgPoster.loadImage(show.path)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        val itemsTvShowsBinding = ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowsViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        holder.bind(listTVShows[position])
        holder.itemView.setOnClickListener {
            onClickListener.onClick(listTVShows[position])
        }
    }

    override fun getItemCount(): Int = listTVShows.size
}