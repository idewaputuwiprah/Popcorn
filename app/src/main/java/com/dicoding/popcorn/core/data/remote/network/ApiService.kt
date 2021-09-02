package com.dicoding.popcorn.core.data.remote.network

import com.dicoding.popcorn.core.data.remote.response.DetailMovieResponse
import com.dicoding.popcorn.core.data.remote.response.DetailTVShowsResponse
import com.dicoding.popcorn.core.data.remote.response.MoviesResponse
import com.dicoding.popcorn.core.data.remote.response.TVShowsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean,
        @Query("page") page: Int
    ): Call<MoviesResponse>

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
    fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DetailMovieResponse>

    @GET("tv/{tv_id}")
    fun getTVShowsDetail(
       @Path("tv_id") id: Int,
       @Query("api_key") apiKey: String,
       @Query("language") language: String
    ): Call<DetailTVShowsResponse>
}