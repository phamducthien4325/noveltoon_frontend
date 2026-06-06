package com.example.noveltoon.domain.repository

import androidx.paging.PagingData
import com.example.noveltoon.data.remote.dto.CreateDraftRequest
import com.example.noveltoon.data.remote.dto.UpdateDraftRequest
import com.example.noveltoon.domain.model.Chapter
import kotlinx.coroutines.flow.Flow

interface ChapterRepository {
    fun getChapters(
        novelId: String
    ): Flow<PagingData<Chapter>>

    suspend fun createDraft(
        request: CreateDraftRequest
    ): Chapter

    suspend fun updateDraft(
        chapterId: String,
        request: UpdateDraftRequest
    ): Chapter

    suspend fun getChapter(
        chapterId: String
    ): Chapter
}