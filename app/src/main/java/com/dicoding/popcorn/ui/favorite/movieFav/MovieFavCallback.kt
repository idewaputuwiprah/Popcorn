package com.dicoding.popcorn.ui.favorite.movieFav

import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity

interface MovieFavCallback {
    fun onClick(data: MovieFavEntity)
}