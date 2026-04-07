package com.example.noveltoon.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.noveltoon.domain.model.Novel
import com.example.noveltoon.domain.repository.NovelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNovelsUseCase @Inject constructor(
    private val repository: NovelRepository
) {
    operator fun invoke(): Flow<PagingData<Novel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                prefetchDistance = 3,
                enablePlaceholders = false
            )
        ) {
            repository.getNovels()
        }.flow
    }
}