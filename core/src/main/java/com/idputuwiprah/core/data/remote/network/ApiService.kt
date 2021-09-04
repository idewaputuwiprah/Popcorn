package com.idputuwiprah.core.data.remote.network

import com.idputuwiprah.core.data.remote.response.DetailMovieResponse
import com.idputuwiprah.core.data.remote.response.DetailTVShowsResponse
import com.idputuwiprah.core.data.remote.response.MoviesResponse
import com.idputuwiprah.core.data.remote.response.TVShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean,
        @Query("page") page: Int
    ): MoviesResponse

    @GET("discover/tv")
    suspend fun getTVShowList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("page") page: Int,
        @Query("timezone") timezone: String,
        @Query("include_null_first_air_dates") includeNullAirDates: Boolean
    ): TVShowsResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): DetailMovieResponse

    @GET("tv/{tv_id}")
    suspend fun getTVShowsDetail(
       @Path("tv_id") id: Int,
       @Query("api_key") apiKey: String,
       @Query("language") language: String
    ): DetailTVShowsResponse
}