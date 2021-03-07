package com.dicoding.popcorn.ui.home

import com.dicoding.popcorn.data.MovieEntity

interface ItemCallback {
    fun onClick(data: MovieEntity)
}