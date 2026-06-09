package com.example.noveltoon.data.repository

import androidx.paging.PagingSource
import com.example.noveltoon.core.utils.safeApiCall
import com.example.noveltoon.data.local.dao.UserDao
import com.example.noveltoon.data.local.entity.UserEntity
import com.example.noveltoon.data.remote.api.UserApi
import com.example.noveltoon.data.remote.pagingSource.FollowingAuthorsPagingSource
import com.example.noveltoon.domain.model.User
import com.example.noveltoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userApi: UserApi
) : UserRepository {
    override suspend fun saveUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    override fun getUser(): Flow<UserEntity?> {
        return userDao.getUser()
    }

    override fun getFollowingAuthors(): PagingSource<Int, User> {
        return FollowingAuthorsPagingSource(userApi)
    }

    override suspend fun followAuthor(authorId: String) {
        safeApiCall { userApi.followAuthor(authorId) }
    }

    override suspend fun unfollowAuthor(authorId: String) {
        safeApiCall { userApi.unfollowAuthor(authorId) }
    }
}