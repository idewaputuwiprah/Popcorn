package com.dicoding.popcorn.core.domain.model

data class Movie(
    val movieId: String = "",
    val title: String = "",
    val rating: String = "",
    val year: String = "",
    val tags: String = "",
    val path: String = "",
    val duration: String = ""
)