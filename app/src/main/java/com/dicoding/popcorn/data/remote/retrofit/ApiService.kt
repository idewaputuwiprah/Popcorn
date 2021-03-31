package com.dicoding.popcorn.data.remote.retrofit

import com.dicoding.popcorn.data.remote.DetailMovieResponse
import com.dicoding.popcorn.data.remote.DetailTVShowsResponse
import com.dicoding.popcorn.data.remote.MoviesResponse
import com.dicoding.popcorn.data.remote.TVShowsResponse
import retrofit2.Call
import retrofit2.Response
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
    ): Response<MoviesResponse>

    @GET("discover/tv")
    fun getTVShowList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("page") page: Int,
        @Query("timezone") timezone: String,
        @Query("include_null_first_air_dates") includeNullAirDates: Boolean
    ): Call<TVShowsResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Response<DetailMovieResponse>

    @GET("tv/{tv_id}")
    fun getTVShowsDetail(
       @Path("tv_id") id: Int,
       @Query("api_key") apiKey: String,
       @Query("language") language: String
    ): Call<DetailTVShowsResponse>
}