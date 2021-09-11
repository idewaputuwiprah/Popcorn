package com.idputuwiprah.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.idputuwiprah.core.data.local.entity.MovieFavEntity
import com.idputuwiprah.core.data.local.entity.TVShowFavEntity

@Database(entities = [MovieFavEntity::class, TVShowFavEntity::class], version = 1, exportSchema = false)
abstract class PopcornRoomDatabase : RoomDatabase() {

    abstract fun popcornDao(): PopcornDAO
}