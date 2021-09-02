package com.dicoding.popcorn.core.domain.model

data class Detail(
        val movieId: String = "",
        val title: String = "",
        val rating: String = "",
        val year: String = "",
        val tags: List<String> = arrayListOf(),
        val path: String = "",
        val duration: String = "",
        val content: String = "",
        val director: String = "",
        val writers: String = "",
        val stars: String = "",
        val backdrop: String = ""
)
