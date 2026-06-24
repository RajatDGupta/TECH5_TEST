package com.tech5.test.core.utils

import retrofit2.HttpException
import java.io.IOException

fun Throwable.toErrorMessage(): String {
    return when (this) {
        is IOException -> "Please check your internet connection"
        is HttpException -> "Something went wrong on server"
        else -> this.localizedMessage ?: "Unexpected error occurred"
    }
}
