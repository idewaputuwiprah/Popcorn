package com.dicoding.popcorn.core.data.remote

import android.util.Log
import com.dicoding.popcorn.BuildConfig
import com.dicoding.popcorn.core.data.remote.network.ApiResponse
import com.dicoding.popcorn.core.data.remote.network.ApiService
import com.dicoding.popcorn.core.data.remote.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
//    companion object {
//        @Volatile
//        private var instance: RemoteDataSource? = null
//
//        fun getInstance(service: ApiService) =
//            instance ?: synchronized(this) {
//                instance ?: RemoteDataSource(service)
//            }
//    }

    fun getMovies(): Flow<ApiResponse<List<ResultsItem>>> {
        return flow {
            try {
                val response = apiService.getMovieList(
                    apiKey = BuildConfig.API_KEY,
                    language = "en-US",
                    sortBy = "popularity.desc",
                    includeAdult = false,
                    includeVideo = false,
                    page = 1
                )
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.SUCCESS(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.ERROR(e.toString()))
                Log.e("Movies API", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getMovieDetail(id: Int): Flow<ApiResponse<DetailMovieResponse>> = flow {
        try {
            val response = apiService.getMovieDetail(
                id = id,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
            )
            emit(ApiResponse.SUCCESS(response))
        } catch (e: Exception) {
            emit(ApiResponse.ERROR(e.toString()))
            Log.d("Detail Movie API", e.toString())
        }
    }.flowOn(Dispatchers.IO)

    fun getTVShows(): Flow<ApiResponse<List<ResultsTVItem>>> = flow {
        try {
            val response = apiService.getTVShowList(
                apiKey = BuildConfig.API_KEY,
                language = "en-US",
                sortBy = "popularity.desc",
                page = 1,
                timezone = "America/New_York",
                includeNullAirDates = false
            )
            val dataArray = response.results
            if (dataArray.isNotEmpty()) {
                emit(ApiResponse.SUCCESS(dataArray))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            emit(ApiResponse.ERROR(e.toString()))
            Log.e("TV Show API", e.toString())
        }
    }.flowOn(Dispatchers.IO)

    fun getTVShowDetail(id: Int): Flow<ApiResponse<DetailTVShowsResponse>> = flow {
        try {
            val response = apiService.getTVShowsDetail(
                id = id,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
            )
            emit(ApiResponse.SUCCESS(response))
        } catch (e: Exception) {
            emit(ApiResponse.ERROR(e.toString()))
            Log.e("Detail TV Show API", e.toString())
        }
    }.flowOn(Dispatchers.IO)
}