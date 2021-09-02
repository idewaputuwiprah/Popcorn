package com.dicoding.popcorn.core.di

import android.content.Context
import com.dicoding.popcorn.core.data.PopcornRepository
import com.dicoding.popcorn.core.data.local.LocalDataSource
import com.dicoding.popcorn.core.data.local.room.PopcornRoomDatabase
import com.dicoding.popcorn.core.data.remote.RemoteDataSource
import com.dicoding.popcorn.core.data.remote.network.ApiConfig
import com.dicoding.popcorn.core.domain.repository.IPopcornRepository
import com.dicoding.popcorn.core.domain.usecase.PopcornInteractor
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase
import com.dicoding.popcorn.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): IPopcornRepository {
        val database = PopcornRoomDatabase.getDatabase(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.getApiService())
        val localDataSource = LocalDataSource.getInstance(database.popcornDao())
        val appExecutors = AppExecutors()
        return PopcornRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun providePopcornUseCase(context: Context): PopcornUseCase {
        val repository = provideRepository(context)
        return PopcornInteractor(repository)
    }
}