package com.example.noveltoon.data.remote.pagingSource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.remote.api.ChapterApi
import com.example.noveltoon.domain.model.Chapter

class ChapterPagingSource(
    private val api: ChapterApi,
    private val novelId: String
) : PagingSource<Int, Chapter>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Chapter> {

        return try {

            val page = params.key ?: 1

            val response = api
                .getNovelChapters(novelId, page, 20)
                .data

            Log.d("API_CALL", "Response: $response")

            LoadResult.Page(
                data = response.items.map { it.toDomain() },
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.page < response.totalPages - 1) page + 1 else null
            )

        } catch (e: Exception) {

            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(
        state: PagingState<Int, Chapter>
    ): Int? {

        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }

    }
}