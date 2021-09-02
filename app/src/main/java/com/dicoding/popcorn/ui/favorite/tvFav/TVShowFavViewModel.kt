package com.dicoding.popcorn.ui.favorite.tvFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class TVShowFavViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavTVShows(): LiveData<PagedList<TVShowFavEntity>> = popcornUseCase.getTVShowFav()
}