package com.idputuwiprah.favorite.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import com.idputuwiprah.favorite.movieFav.MovieFavViewModel
import com.idputuwiprah.favorite.tvFav.TVShowFavViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val popcornUseCase: PopcornUseCase):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MovieFavViewModel::class.java) -> {
                MovieFavViewModel(popcornUseCase) as T
            }
            modelClass.isAssignableFrom(TVShowFavViewModel::class.java) -> {
                TVShowFavViewModel(popcornUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}