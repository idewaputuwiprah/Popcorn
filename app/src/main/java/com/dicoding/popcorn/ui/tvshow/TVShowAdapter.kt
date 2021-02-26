package com.dicoding.popcorn.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.databinding.ItemsTvshowsBinding
import com.dicoding.popcorn.ui.detail.DetailActivity
import java.lang.StringBuilder

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowsViewHolder>() {
    private val listTVShows = ArrayList<MovieEntity>()

    fun setShows(shows: List<MovieEntity>) {
        this.listTVShows.clear()
        this.listTVShows.addAll(shows)
    }

    class TVShowsViewHolder(private val binding: ItemsTvshowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: MovieEntity) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemYears.text = show.year
                tvRating.text = StringBuilder("${show.rating}/10")

                Glide.with(itemView.context)
                        .load(show.path)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_error))
                        .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.apply {
                        putExtra(DetailActivity.ITEM_TYPE, "tv_show")
                        putExtra(DetailActivity.ITEM_ID, show.movieId)
                    }
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        val itemsTvShowsBinding = ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowsViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        holder.bind(listTVShows[position])
    }

    override fun getItemCount(): Int = listTVShows.size
}