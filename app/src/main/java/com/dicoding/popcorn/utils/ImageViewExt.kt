package com.dicoding.popcorn.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.popcorn.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh).error(R.drawable.ic_error))
        .into(this)
}