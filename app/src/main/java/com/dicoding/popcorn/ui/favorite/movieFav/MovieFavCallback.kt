package com.dicoding.popcorn.ui.favorite.movieFav

import com.dicoding.popcorn.data.local.MovieFavEntity

interface MovieFavCallback {
    fun onClick(data: MovieFavEntity)
}