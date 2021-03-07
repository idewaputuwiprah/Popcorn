package com.dicoding.popcorn.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieFavEntity::class, TVShowFavEntity::class], version = 1, exportSchema = false)
abstract class PopcornRoomDatabase : RoomDatabase() {
    abstract fun popcornDao(): PopcornDAO

    companion object {
        @Volatile
        private var instance: PopcornRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): PopcornRoomDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context.applicationContext, PopcornRoomDatabase::class.java, "popcorn_database").build()
            }
    }
}