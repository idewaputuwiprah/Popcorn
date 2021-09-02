package com.dicoding.popcorn.ui.favorite.movieFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class MovieFavViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavMovies(): LiveData<List<Movie>> = popcornUseCase.getMoviesFav()
}