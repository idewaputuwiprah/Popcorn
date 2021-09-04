package com.dicoding.popcorn.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.idputuwiprah.core.domain.model.Movie
import com.dicoding.popcorn.databinding.ItemsTvshowsBinding
import com.dicoding.popcorn.ui.home.ItemCallback
import java.lang.StringBuilder

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowsViewHolder>() {
    private val listTVShows = ArrayList<Movie>()
    private lateinit var onClickListener: ItemCallback

    fun setOnClickListener(onClickListener: ItemCallback) {
        this.onClickListener = onClickListener
    }

    fun setShows(shows: List<Movie>?) {
        if (shows == null) return
        this.listTVShows.clear()
        this.listTVShows.addAll(shows)
        notifyDataSetChanged()
    }

    class TVShowsViewHolder(private val binding: ItemsTvshowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Movie) {
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