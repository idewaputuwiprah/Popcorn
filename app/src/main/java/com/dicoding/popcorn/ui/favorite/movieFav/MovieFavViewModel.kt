package com.dicoding.popcorn.ui.favorite.movieFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieFavViewModel @Inject constructor(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavMovies(): LiveData<List<Movie>> = popcornUseCase.getMoviesFav().asLiveData()
}