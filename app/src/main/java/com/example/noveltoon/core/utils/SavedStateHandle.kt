package com.example.noveltoon.core.utils

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.StateFlow

fun <T> SavedStateHandle.setResult(key: String, value: T) {
    set(key, value)
}

fun <T> SavedStateHandle.getResultFlow(key: String): StateFlow<T?> {
    return getStateFlow(key, null)
}