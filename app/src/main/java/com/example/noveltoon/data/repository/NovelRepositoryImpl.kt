package com.example.noveltoon.data.repository

import androidx.paging.PagingSource
import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.remote.api.NovelApi
import com.example.noveltoon.data.remote.pagingSource.NovelPagingSource
import com.example.noveltoon.domain.model.Novel
import com.example.noveltoon.domain.repository.NovelRepository
import javax.inject.Inject

class NovelRepositoryImpl @Inject constructor(
    private val api: NovelApi
) : NovelRepository {

    override fun getNovels(): PagingSource<Int, Novel> {
//        return api.getNovels().data.items.map { it.toDomain() }
        return NovelPagingSource(api)
    }
}