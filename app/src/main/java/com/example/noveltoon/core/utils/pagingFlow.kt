package com.example.noveltoon.core.utils

import androidx.paging.PagingData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest

@OptIn(ExperimentalCoroutinesApi::class)
fun <T : Any> pagingFlow(
    trigger: Flow<Any>,
    block: () -> Flow<PagingData<T>>
): Flow<PagingData<T>> {
    return trigger
        .flatMapLatest {
            block()
        }
}