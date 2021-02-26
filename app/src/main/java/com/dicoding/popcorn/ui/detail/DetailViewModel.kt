package com.dicoding.popcorn.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.data.DetailEntity
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.utils.DataDummy

class DetailViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {
    private lateinit var itemId: String

    fun setItem(itemId: String) {
        this.itemId = itemId
    }

    fun getRemoteMovieDetail(): LiveData<DetailEntity> = popcornRepository.getDetailMovie(itemId.toInt())

    fun getRemoteTVShowDetail(): LiveData<DetailEntity> = popcornRepository.getDetailTVShows(itemId.toInt())

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()

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