package com.dicoding.popcorn.di

import android.content.Context
import com.dicoding.popcorn.data.PopcornRepository

object Injection {
    fun provideRepository(context: Context): PopcornRepository {
        return PopcornRepository.getInstance()
    }
}