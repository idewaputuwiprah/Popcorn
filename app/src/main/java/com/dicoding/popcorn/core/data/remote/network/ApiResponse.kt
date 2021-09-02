package com.dicoding.popcorn.core.data.remote.network

sealed class ApiResponse<out R> {
    data class SUCCESS<out T>(val data: T): ApiResponse<T>()
    data class ERROR(val errorMessage: String): ApiResponse<Nothing>()
    object Empty: ApiResponse<Nothing>()
}