package com.example.noveltoon.data.remote.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.remote.api.UserApi
import com.example.noveltoon.domain.model.User

class FollowingAuthorsPagingSource(
    private val api: UserApi
) : PagingSource<Int, User>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, User> {
        return try {
            val page = params.key ?: 1
            val response = api.getFollowingAuthors(page, 20).data
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
        state: PagingState<Int, User>
    ): Int? {
        return state.anchorPosition
    }
}
