package com.dicoding.popcorn.ui.favorite.tvFav

import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity

interface TVShowFavCallback {
    fun onClick(data: TVShowFavEntity)
}