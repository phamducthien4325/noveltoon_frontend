package com.example.noveltoon.domain.repository

import androidx.paging.PagingSource
import com.example.noveltoon.data.remote.dto.CreateNovelRequest
import com.example.noveltoon.data.remote.responseDTO.ApiResult
import com.example.noveltoon.domain.model.Novel

interface NovelRepository {
    fun getNovels(): PagingSource<Int, Novel>

    fun getMyNovels(): PagingSource<Int, Novel>

    suspend fun createNovel(request: CreateNovelRequest): Novel
}