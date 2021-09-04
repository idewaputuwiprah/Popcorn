package com.idputuwiprah.core.di

import android.content.Context
import androidx.room.Room
import com.idputuwiprah.core.data.local.room.PopcornDAO
import com.idputuwiprah.core.data.local.room.PopcornRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PopcornRoomDatabase = Room.databaseBuilder(
        context,
        PopcornRoomDatabase::class.java,
        "popcorn_database"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun providePopcornDao(database: PopcornRoomDatabase): PopcornDAO = database.popcornDao()
}