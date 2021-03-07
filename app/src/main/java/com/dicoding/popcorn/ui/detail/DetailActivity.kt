package com.dicoding.popcorn.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.dicoding.popcorn.data.local.MovieFavEntity
import com.dicoding.popcorn.data.local.TVShowFavEntity
import com.dicoding.popcorn.databinding.ActivityDetailBinding
import com.dicoding.popcorn.databinding.ContentDetailBinding
import com.dicoding.popcorn.viewmodels.ViewModelFactory
import com.jaeger.library.StatusBarUtil

class DetailActivity : AppCompatActivity() {
    companion object {
        const val ITEM_TYPE = "type"
        const val ITEM_ID = "item_id"
        const val MOVIE_TYPE = "movie"
        const val TV_SHOW_TYPE = "tv_show"
    }
    private lateinit var contentDetailBinding: ContentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null
    private var type = ""
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        contentDetailBinding = activityDetailBinding.detailContent
        StatusBarUtil.setTransparent(this)

        val itemType = intent.getStringExtra(ITEM_TYPE)
        val itemId = intent.getStringExtra(ITEM_ID)
        if (itemId != null && itemType != null) {
            this.type = itemType
            val factory = ViewModelFactory.getInstance(this)
            viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
            viewModel.setItem(itemId)
            supportActionBar?.title  = if (itemType == MOVIE_TYPE)
                resources.getString(R.string.movie_detail)
            else
                resources.getString(R.string.tv_show_detail)

            if (itemType == MOVIE_TYPE) {
                getMovieDetail(viewModel)
            } else getTVShowDetail(viewModel)

            viewModel.getLoadingStatus().observe(this, {
                with(contentDetailBinding) {
                    progressBar.visibility = if (it) View.VISIBLE else View.GONE
                }
            })
        }
    }

    private fun getTVShowDetail(viewModel: DetailViewModel) {
        viewModel.getRemoteTVShowDetail().observeOnce(this, { detail->
            viewModel.item = detail
            with(contentDetailBinding) {
                tvItemTitle.text = detail.title
                tvItemYear.text = detail.year
                tvItemTags.text = detail.tags.joinToString()
                tvRating.text = detail.rating
                tvDuration.text = detail.duration
                tvDetail.text = detail.content

                tvDirector.text = detail.director
                tvWriters.text = detail.writers
                tvStars.text = detail.stars

                Glide.with(this@DetailActivity)
                        .load(detail.backdrop)
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_refresh)
                                        .error(R.drawable.ic_error)
                        )
                        .into(imgPoster)
            }
        })
    }

    private fun getMovieDetail(viewModel: DetailViewModel) {
        viewModel.getRemoteMovieDetail().observeOnce(this, { detail->
            viewModel.item = detail
            with(contentDetailBinding) {
                tvItemTitle.text = detail.title
                tvItemYear.text = detail.year
                tvItemTags.text = detail.tags.joinToString()
                tvRating.text = detail.rating
                tvDuration.text = detail.duration
                tvDetail.text = detail.content

                tvDirector.text = detail.director
                tvWriters.text = detail.writers
                tvStars.text = detail.stars

                Glide.with(this@DetailActivity)
                        .load(detail.backdrop)
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_refresh)
                                        .error(R.drawable.ic_error)
                        )
                        .into(imgPoster)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        this.onBackPressed()
        return true
    }

    private fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        observe(lifecycleOwner, object : Observer<T> {
            override fun onChanged(t: T?) {
                observer.onChanged(t)
                removeObserver(this)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        if (type == MOVIE_TYPE) {
            viewModel.getMovieFavorite().observe(this, { movie ->
                this.isFavorite = movie != null
                setBookmarkState()
            })
        } else {
            viewModel.getTVShowFavorite().observe(this, { tvShow->
                this.isFavorite = tvShow != null
                setBookmarkState()
            })
        }
        return true
    }

    private fun setBookmarkState() {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (isFavorite) menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        else menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_favorite -> {
                if (type == MOVIE_TYPE) {
                    if (!isFavorite) {
                        val movies = ArrayList<MovieFavEntity>()
                        val entity = getMovieFavEntity()
                        movies.add(entity)
                        viewModel.insertMovieFavorite(movies)
                    }
                    else {
                       viewModel.deleteMovie(getMovieFavEntity())
                    }
                }
                else {
                    if (!isFavorite) {
                        val tvShows = ArrayList<TVShowFavEntity>()
                        val entity = getTVShowFavEntity()
                        tvShows.add(entity)
                        viewModel.insertTVShowFavorite(tvShows)
                    }
                    else {
                        viewModel.deleteTVShow(getTVShowFavEntity())
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getMovieFavEntity(): MovieFavEntity {
        lateinit var movieFav: MovieFavEntity
        val detail = viewModel.item
        if (detail != null) {
            movieFav = MovieFavEntity(
                movieId = detail.movieId,
                title = detail.title,
                rating = detail.rating,
                year = detail.year,
                tags = detail.tags.joinToString(),
                path = detail.path,
                duration = detail.duration
            )
        }
        return movieFav
    }

    private fun getTVShowFavEntity(): TVShowFavEntity {
        lateinit var tvFav: TVShowFavEntity
        val detail = viewModel.item
        if (detail != null) {
            tvFav = TVShowFavEntity(
                tvShowId = detail.movieId,
                title = detail.title,
                rating = detail.rating,
                year = detail.year,
                tags = detail.tags.joinToString(),
                path = detail.path,
                duration = detail.duration
            )
        }
        return tvFav
    }
}