package com.example.noveltoon.domain.repository

import androidx.paging.PagingSource
import com.example.noveltoon.data.local.entity.UserEntity
import com.example.noveltoon.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveUser(user: UserEntity)

    fun getUser(): Flow<UserEntity?>

    fun getFollowingAuthors(): PagingSource<Int, User>

    suspend fun followAuthor(authorId: String)

    suspend fun unfollowAuthor(authorId: String)
}
