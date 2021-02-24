package com.dicoding.popcorn.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var itemId: String

    fun setItem(itemId: String) {
        this.itemId = itemId
    }

    fun getMovie() : MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == itemId) {
                movie = movieEntity
                break
            }
        }
        return movie
    }

    fun getTVShow() : MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyTVShows()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == itemId) {
                movie = movieEntity
                break
            }
        }
        return movie
    }
}