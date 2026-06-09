package com.example.noveltoon.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.noveltoon.domain.model.User
import com.example.noveltoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFollowingAuthorsUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                prefetchDistance = 3,
                enablePlaceholders = false
            )
        ) {
            repository.getFollowingAuthors()
        }.flow
    }
}
