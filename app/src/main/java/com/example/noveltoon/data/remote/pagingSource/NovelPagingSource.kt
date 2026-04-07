package com.example.noveltoon.data.remote.pagingSource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.remote.api.NovelApi
import com.example.noveltoon.domain.model.Novel

class NovelPagingSource(
    private val api: NovelApi
) : PagingSource<Int, Novel>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Novel> {

        return try {

            val page = params.key ?: 1

            val response = api.getNovels(page, 20).data

            LoadResult.Page(
                data = response.items.map { it.toDomain() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.page < response.totalPages) page + 1 else null
            )

        } catch (e: Exception) {

            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(
        state: PagingState<Int, Novel>
    ): Int? {
        return state.anchorPosition
    }
}