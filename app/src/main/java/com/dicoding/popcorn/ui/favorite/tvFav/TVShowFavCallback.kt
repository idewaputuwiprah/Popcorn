package com.dicoding.popcorn.ui.favorite.tvFav

import com.dicoding.popcorn.data.local.TVShowFavEntity

interface TVShowFavCallback {
    fun onClick(data: TVShowFavEntity)
}