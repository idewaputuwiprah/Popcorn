package com.idputuwiprah.core.domain.usecase

import androidx.lifecycle.LiveData
import com.idputuwiprah.core.data.Resource
import com.idputuwiprah.core.domain.model.Detail
import com.idputuwiprah.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface PopcornUseCase {
    fun getRemoteMovies(): Flow<Resource<List<Movie>>>

    fun getDetailMovie(id: Int): Flow<Resource<Detail>>

    fun getRemoteTVShows(): Flow<Resource<List<Movie>>>

    fun getDetailTVShows(id: Int): Flow<Resource<Detail>>

    fun getMoviesFav(): Flow<List<Movie>>

    fun getMovieFav(movieId: String): Flow<Movie?>

    fun getTVShowsFav(): Flow<List<Movie>>

    fun getTVShowFav(tvId:String): Flow<Movie?>

    suspend fun insertMovieFav(movieDetail: Detail)

    suspend fun insertTVShowFav(tvShowDetail: Detail)

    fun deleteMovieFav(movieDetail: Detail)

    fun deleteTVShowFav(tvShowDetail: Detail)
}