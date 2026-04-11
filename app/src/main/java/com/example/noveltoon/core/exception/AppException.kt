package com.example.noveltoon.core.exception

sealed class AppException : Exception() {

    object Network : AppException()

    data class Api(val code: Int, override val message: String?) : AppException()

    data class Validation(override val message: String) : AppException()

    object Unauthorized : AppException()

    object Unknown : AppException()
}