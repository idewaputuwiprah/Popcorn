package com.dicoding.popcorn.utils

class Helper() {
    companion object {
        @Volatile
        private var instance: Helper? = null

        fun getInstance(): Helper =
            instance ?: synchronized(this) {
                instance ?: Helper()
            }
    }

    fun getGenre() {

    }
}