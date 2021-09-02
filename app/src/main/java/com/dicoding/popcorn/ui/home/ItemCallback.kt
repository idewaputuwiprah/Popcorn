package com.dicoding.popcorn.ui.home

import com.dicoding.popcorn.core.domain.model.Movie

interface ItemCallback {
    fun onClick(data: Movie)
}