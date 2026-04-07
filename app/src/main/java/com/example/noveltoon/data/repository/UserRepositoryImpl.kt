package com.example.noveltoon.data.repository

import com.example.noveltoon.data.local.dao.UserDao
import com.example.noveltoon.data.local.entity.UserEntity
import com.example.noveltoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun saveUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    override fun getUser(): Flow<UserEntity?> {
        return userDao.getUser()

    }
}