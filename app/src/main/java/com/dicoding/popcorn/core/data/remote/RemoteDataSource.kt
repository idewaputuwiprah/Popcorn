package com.dicoding.popcorn.core.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.popcorn.BuildConfig
import com.dicoding.popcorn.core.data.remote.network.ApiResponse
import com.dicoding.popcorn.core.data.remote.network.ApiService
import com.dicoding.popcorn.core.data.remote.response.*
import com.dicoding.popcorn.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService) =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getMovies(): LiveData<ApiResponse<List<ResultsItem>>> {
        val resultData = MutableLiveData<ApiResponse<List<ResultsItem>>>()
        EspressoIdlingResource.increment()
        val client = apiService.getMovieList(
            apiKey = BuildConfig.API_KEY,
            language = "en-US",
            sortBy = "popularity.desc",
            includeAdult = false,
            includeVideo = false,
            page = 1
        )
        EspressoIdlingResource.decrement()
        client.enqueue(object : Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                val dataArray = response.body()?.results
                resultData.value = if (dataArray != null) ApiResponse.SUCCESS(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                resultData.value = ApiResponse.ERROR(t.message.toString())
                Log.d("Movie API", t.message.toString())
            }

        })
        return resultData
    }

    fun getMovieDetail(id: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        val resultData = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        EspressoIdlingResource.increment()
        val client = apiService.getMovieDetail(
            id = id,
            apiKey = BuildConfig.API_KEY,
            language = "en-US"
        )
        EspressoIdlingResource.decrement()
        client.enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(call: Call<DetailMovieResponse>, response: Response<DetailMovieResponse>) {
                val data = response.body()
                resultData.value = if (data != null) ApiResponse.SUCCESS(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                resultData.value = ApiResponse.ERROR(t.message.toString())
                Log.d("Detail Movie API", t.message.toString())
            }
        })
        return resultData
    }

    fun getTVShows(): LiveData<ApiResponse<List<ResultsTVItem>>> {
        val resultData = MutableLiveData<ApiResponse<List<ResultsTVItem>>>()
        EspressoIdlingResource.increment()
        val client = apiService.getTVShowList(
            apiKey = BuildConfig.API_KEY,
            language = "en-US",
            sortBy = "popularity.desc",
            page = 1,
            timezone = "America/New_York",
            includeNullAirDates = false
        )
        EspressoIdlingResource.decrement()
        client.enqueue(object : Callback<TVShowsResponse>{
            override fun onResponse(call: Call<TVShowsResponse>, response: Response<TVShowsResponse>) {
                val dataArray = response.body()?.results
                resultData.value = if (dataArray != null) ApiResponse.SUCCESS(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<TVShowsResponse>, t: Throwable) {
                resultData.value = ApiResponse.ERROR(t.message.toString())
                Log.d("TV Show API", t.message.toString())
            }
        })
        return resultData
    }

    fun getTVShowDetail(id: Int): LiveData<ApiResponse<DetailTVShowsResponse>> {
        val resultData = MutableLiveData<ApiResponse<DetailTVShowsResponse>>()
        EspressoIdlingResource.increment()
        val client = apiService.getTVShowsDetail(
            id = id,
            apiKey = BuildConfig.API_KEY,
            language = "en-US"
        )
        EspressoIdlingResource.decrement()
        client.enqueue(object : Callback<DetailTVShowsResponse>{
            override fun onResponse(call: Call<DetailTVShowsResponse>, response: Response<DetailTVShowsResponse>) {
                val data = response.body()
                resultData.value = if (data != null) ApiResponse.SUCCESS(data) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<DetailTVShowsResponse>, t: Throwable) {
                resultData.value = ApiResponse.ERROR(t.message.toString())
                Log.d("Detail TV Show API", t.message.toString())
            }
        })
        return resultData
    }
}