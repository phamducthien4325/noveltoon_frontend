package com.example.noveltoon.domain.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.noveltoon.domain.model.Chapter
import kotlinx.coroutines.flow.Flow

interface ChapterRepository {
    fun getChapters(
        novelId: String
    ): Flow<PagingData<Chapter>>
}