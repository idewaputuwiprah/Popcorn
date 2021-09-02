package com.dicoding.popcorn.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.popcorn.core.data.PopcornRepository
import com.dicoding.popcorn.core.di.Injection
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase
import com.dicoding.popcorn.ui.detail.DetailViewModel
import com.dicoding.popcorn.ui.favorite.movieFav.MovieFavViewModel
import com.dicoding.popcorn.ui.favorite.tvFav.TVShowFavViewModel
import com.dicoding.popcorn.ui.movie.MovieViewModel
import com.dicoding.popcorn.ui.tvshow.TVShowViewModel

class ViewModelFactory private constructor(
    private val popcornUseCase: PopcornUseCase
    ): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.providePopcornUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(popcornUseCase) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(popcornUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(popcornUseCase) as T
            }
            modelClass.isAssignableFrom(MovieFavViewModel::class.java) -> {
                MovieFavViewModel(popcornUseCase) as T
            }
            modelClass.isAssignableFrom(TVShowFavViewModel::class.java) -> {
                TVShowFavViewModel(popcornUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}