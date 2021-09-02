package com.dicoding.popcorn.ui.favorite.movieFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.popcorn.core.data.PopcornRepository
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class MovieFavViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavMovies(): LiveData<PagedList<MovieFavEntity>> = popcornUseCase.getMovieFav()
}