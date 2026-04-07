package com.example.noveltoon.domain.repository

import com.example.noveltoon.data.local.dao.UserDao
import com.example.noveltoon.data.remote.dto.LoginRequest
import com.example.noveltoon.data.remote.responseDTO.ApiResult
import com.example.noveltoon.domain.model.AuthToken

interface AuthRepository {
    suspend fun login(
        loginRequest: LoginRequest,
    ): ApiResult<AuthToken>
}