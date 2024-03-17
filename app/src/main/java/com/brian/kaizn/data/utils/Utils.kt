package com.brian.kaizn.data.utils

sealed class Rezults<T> {
    data class Success<T>(val data: T) : Rezults<T>()
    data class Error<T>(val message: String? = null, val exception: Exception? = null) :
        Rezults<T>()

}