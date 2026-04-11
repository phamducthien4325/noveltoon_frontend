package com.example.noveltoon.core.utils

import com.example.noveltoon.core.exception.AppException
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(block: suspend () -> T): T {
    return try {
        block()
    } catch (e: IOException) {
        throw AppException.Network
    } catch (e: HttpException) {
        if (e.code() == 401) throw AppException.Unauthorized
        throw AppException.Api(e.code(), e.message())
    } catch (e: Exception) {
        throw AppException.Unknown
    }
}