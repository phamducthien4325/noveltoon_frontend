package com.example.noveltoon.core.utils

import com.example.noveltoon.core.exception.AppException
import com.example.noveltoon.core.exception.mapper.toMessage

sealed class ActionState<out T> {
    object Idle : ActionState<Nothing>()
    object Loading : ActionState<Nothing>()
    data class Success<T>(val data: T) : ActionState<T>()
    data class Error(val message: String) : ActionState<Nothing>()
}

suspend fun <T> runUseCase(
    block: suspend () -> T
): ActionState<T> {
    return try {
        ActionState.Success(block())
    } catch (e: AppException) {
        ActionState.Error(e.toMessage())
    } catch (e: Exception) {
        ActionState.Error("Unknown error")
    }
}