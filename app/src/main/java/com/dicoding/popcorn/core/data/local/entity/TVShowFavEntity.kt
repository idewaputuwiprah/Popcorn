package com.dicoding.popcorn.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShowFav")
data class TVShowFavEntity(
    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "tags")
    var tags: String,

    @ColumnInfo(name = "path")
    var path: String,

    @ColumnInfo(name = "duration")
    var duration: String
)
