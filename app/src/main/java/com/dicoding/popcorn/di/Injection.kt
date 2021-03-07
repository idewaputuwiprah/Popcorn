package com.dicoding.popcorn.di

import android.content.Context
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.local.LocalDataSource
import com.dicoding.popcorn.data.local.PopcornRoomDatabase
import com.dicoding.popcorn.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): PopcornRepository {
        val database = PopcornRoomDatabase.getDatabase(context)

        val localDataSource = LocalDataSource.getInstance(database.popcornDao())
        val appExecutors = AppExecutors()
        return PopcornRepository.getInstance(localDataSource, appExecutors)
    }
}