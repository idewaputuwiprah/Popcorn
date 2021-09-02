package com.dicoding.popcorn.ui.favorite.tvFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class TVShowFavViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavTVShows(): LiveData<List<Movie>> = popcornUseCase.getTVShowsFav()
}