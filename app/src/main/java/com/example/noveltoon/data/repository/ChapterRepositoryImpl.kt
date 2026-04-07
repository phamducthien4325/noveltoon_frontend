package com.example.noveltoon.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.noveltoon.data.remote.api.ChapterApi
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
}