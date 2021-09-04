package com.idputuwiprah.favorite.movieFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.domain.usecase.PopcornUseCase

class MovieFavViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavMovies(): LiveData<List<Movie>> = popcornUseCase.getMoviesFav().asLiveData()
}