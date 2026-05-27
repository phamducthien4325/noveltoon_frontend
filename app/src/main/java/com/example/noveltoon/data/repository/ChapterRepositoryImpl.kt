package com.example.noveltoon.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.noveltoon.core.utils.safeApiCall
import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.remote.api.ChapterApi
import com.example.noveltoon.data.remote.dto.CreateDraftRequest
import com.example.noveltoon.data.remote.dto.UpdateDraftRequest
import com.example.noveltoon.data.remote.pagingSource.ChapterPagingSource
import com.example.noveltoon.domain.model.Chapter
import com.example.noveltoon.domain.repository.ChapterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChapterRepositoryImpl @Inject constructor(
    private val api: ChapterApi
) : ChapterRepository {

    override fun getChapters(novelId: String): Flow<PagingData<Chapter>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                prefetchDistance = 3,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ChapterPagingSource(api, novelId)
            }
        ).flow
    }

    override suspend fun createDraft(request: CreateDraftRequest): Chapter {
        return safeApiCall { api.createDraft(request).data.toDomain() }
    }

    override suspend fun updateDraft(chapterId: String, request: UpdateDraftRequest): Chapter {
        return safeApiCall { api.updateDraft(chapterId, request).data.toDomain() }
    }
}