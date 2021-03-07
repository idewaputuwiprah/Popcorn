package com.dicoding.popcorn.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.di.Injection
import com.dicoding.popcorn.ui.detail.DetailViewModel
import com.dicoding.popcorn.ui.favorite.movieFav.MovieFavViewModel
import com.dicoding.popcorn.ui.favorite.tvFav.TVShowFavViewModel
import com.dicoding.popcorn.ui.movie.MovieViewModel
import com.dicoding.popcorn.ui.tvshow.TVShowViewModel

class ViewModelFactory private constructor(private val mPopcornRepository: PopcornRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mPopcornRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(mPopcornRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mPopcornRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavViewModel::class.java) -> {
                MovieFavViewModel(mPopcornRepository) as T
            }
            modelClass.isAssignableFrom(TVShowFavViewModel::class.java) -> {
                TVShowFavViewModel(mPopcornRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}