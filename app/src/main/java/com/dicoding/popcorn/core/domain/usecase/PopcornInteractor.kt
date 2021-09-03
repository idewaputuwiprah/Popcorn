package com.dicoding.popcorn.core.domain.usecase

import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.repository.IPopcornRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopcornInteractor @Inject constructor(private val popcornRepository: IPopcornRepository): PopcornUseCase {
    override fun getRemoteMovies(): Flow<Resource<List<Movie>>> =
        popcornRepository.getRemoteMovies()

    override fun getDetailMovie(id: Int): Flow<Resource<Detail>> =
        popcornRepository.getDetailMovie(id)

    override fun getRemoteTVShows(): Flow<Resource<List<Movie>>> =
        popcornRepository.getRemoteTVShows()

    override fun getDetailTVShows(id: Int): Flow<Resource<Detail>> =
        popcornRepository.getDetailTVShows(id)

    override fun getMoviesFav(): Flow<List<Movie>> =
        popcornRepository.getMoviesFav()

    override fun getMovieFav(movieId: String): Flow<Movie?> =
        popcornRepository.getMovieFav(movieId)

    override fun getTVShowsFav(): Flow<List<Movie>> =
        popcornRepository.getTVShowsFav()

    override fun getTVShowFav(tvId: String): Flow<Movie?> =
        popcornRepository.getTVShowFav(tvId)

    override suspend fun insertMovieFav(movieDetail: Detail) {
        popcornRepository.insertMovieFav(movieDetail)
    }

    override suspend fun insertTVShowFav(tvShowDetail: Detail) {
        popcornRepository.insertTVShowFav(tvShowDetail)
    }

    override fun deleteMovieFav(movieDetail: Detail) {
        popcornRepository.deleteMovieFav(movieDetail)
    }

    override fun deleteTVShowFav(tvShowDetail: Detail) {
        popcornRepository.deleteTVShowFav(tvShowDetail)
    }
}