package com.dicoding.popcorn.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.dicoding.popcorn.databinding.ActivityDetailBinding
import com.dicoding.popcorn.databinding.ContentDetailBinding
import com.dicoding.popcorn.viewmodels.ViewModelFactory
import com.jaeger.library.StatusBarUtil

class DetailActivity : AppCompatActivity() {
    companion object {
        const val ITEM_TYPE = "type"
        const val ITEM_ID = "item_id"
        private const val MOVIE_TYPE = "movie"
    }
    private lateinit var contentDetailBinding: ContentDetailBinding

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
            val factory = ViewModelFactory.getInstance(this)
            val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
            viewModel.setItem(itemId)
            supportActionBar?.title  = if (itemType == MOVIE_TYPE) "Movie Detail" else "TV Show Detail"

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
                        .load(detail.path)
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
                        .load(detail.path)
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
}