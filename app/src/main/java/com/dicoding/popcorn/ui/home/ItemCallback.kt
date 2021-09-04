package com.dicoding.popcorn.ui.home

import com.idputuwiprah.core.domain.model.Movie

interface ItemCallback {
    fun onClick(data: Movie)
}