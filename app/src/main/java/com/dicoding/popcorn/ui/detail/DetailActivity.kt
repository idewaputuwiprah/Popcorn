package com.dicoding.popcorn.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.dicoding.popcorn.R
import com.dicoding.popcorn.databinding.ActivityDetailBinding
import com.dicoding.popcorn.databinding.ContentDetailBinding
import com.dicoding.popcorn.utils.loadImage
import com.idputuwiprah.core.data.Resource
import com.idputuwiprah.core.domain.model.Detail
import com.jaeger.library.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var activityDetailBinding: ActivityDetailBinding
    private lateinit var contentDetailBinding: ContentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private var menu: Menu? = null
    private var type = ""
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        contentDetailBinding = activityDetailBinding.detailContent
        StatusBarUtil.setTransparent(this)

        contentDetailBinding.progressBar.visibility = View.VISIBLE

        val itemType = intent.getStringExtra(ITEM_TYPE)
        val itemId = intent.getStringExtra(ITEM_ID)
        if (itemId != null && itemType != null) {
            this.type = itemType

            viewModel.setItem(itemId)
            supportActionBar?.title  = if (itemType == MOVIE_TYPE)
                resources.getString(R.string.movie_detail)
            else
                resources.getString(R.string.tv_show_detail)

            if (itemType == MOVIE_TYPE) {
                getMovieDetail()
            } else getTVShowDetail(viewModel)
        }
    }

    private fun getTVShowDetail(viewModel: DetailViewModel) {
        viewModel.getRemoteTVShowDetail().observeOnce(this, { detail->
            getData(detail)
        })
    }

    private fun getMovieDetail() {
        viewModel.getRemoteMovieDetail().observeOnce(this, { detail->
            getData(detail)
        })
    }

    private fun getData(detail: Resource<Detail>?) {
        if (detail != null) {
            when (detail) {
                is Resource.Success -> {
                    val data = detail.data
                    viewModel.item = data
                    setToView(data!!)
                }
                is Resource.Error -> {
                    activityDetailBinding.apply {
                        detailItem.visibility = View.GONE
                        tvDetailNotFound.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun setToView(detail: Detail) {
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
            imgPoster.loadImage(detail.backdrop)
            progressBar.visibility = View.GONE
        }
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
            viewModel.getMovieFavorite().observe(this) { movieFav->
                this.isFavorite = movieFav != null
                setBookmarkState()
            }
        } else {
            viewModel.getTVShowFavorite().observe(this) { tvShowFav->
                this.isFavorite = tvShowFav != null
                setBookmarkState()
            }
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
                        viewModel.insertMovieFavorite(viewModel.item!!)
                    }
                    else {
                       viewModel.deleteMovie(viewModel.item!!)
                    }
                }
                else {
                    if (!isFavorite) {
                        viewModel.insertTVShowFavorite(viewModel.item!!)
                    }
                    else {
                        viewModel.deleteTVShow(viewModel.item!!)
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val ITEM_TYPE = "type"
        const val ITEM_ID = "item_id"
        const val MOVIE_TYPE = "movie"
        const val TV_SHOW_TYPE = "tv_show"
    }
}