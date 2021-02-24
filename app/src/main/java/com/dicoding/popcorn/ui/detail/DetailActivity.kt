package com.dicoding.popcorn.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R
import com.dicoding.popcorn.databinding.ActivityDetailBinding
import com.dicoding.popcorn.databinding.ContentDetailBinding
import com.jaeger.library.StatusBarUtil

class DetailActivity : AppCompatActivity() {
    companion object {
        const val ITEM_ID = "item_id"
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

        val itemId = intent.getStringExtra(ITEM_ID)
        if (itemId != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
            viewModel.setItem(itemId)
            val item = if (itemId.contains("m")) viewModel.getMovie() else viewModel.getTVShow()
            supportActionBar?.title  = if (itemId.contains("m")) "Movie Detail" else "TV Show Detail"
            with(contentDetailBinding) {
                tvItemTitle.text = item.title
                tvItemYear.text = item.year
                tvItemTags.text = item.tags
                tvRating.text = item.rating
                tvDuration.text = item.duration
                tvDetail.text = item.detail?.content
                tvDirector.text = item.detail?.director
                tvWriters.text = item.detail?.writers
                tvStars.text = item.detail?.stars

                Glide.with(this@DetailActivity)
                    .load(item.path)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_refresh)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        this.onBackPressed()
        return true
    }
}