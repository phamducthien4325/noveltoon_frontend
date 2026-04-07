package com.example.noveltoon.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.noveltoon.core.datastore.TokenManager
import com.example.noveltoon.data.local.dao.UserDao
import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.mapper.toEntity
import com.example.noveltoon.data.remote.api.AuthApi
import com.example.noveltoon.data.remote.dto.LoginRequest
import com.example.noveltoon.data.remote.responseDTO.ApiResult
import com.example.noveltoon.domain.model.AuthToken
import com.example.noveltoon.domain.repository.AuthRepository
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val tokenManager: TokenManager,
    private val userDao: UserDao
) : AuthRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun login(
        loginRequest: LoginRequest,
    ): ApiResult<AuthToken> {
        return try {
            val response = api.login(loginRequest)
            tokenManager.saveTokens(
                response.data.accessToken,
                response.data.refreshToken
            )
            userDao.insertUser(response.data.user.toEntity())
            ApiResult.Success(response.data.toDomain())
        } catch (e: IOException) {

            ApiResult.Error("Không thể kết nối tới server")

        } catch (e: HttpException) {

            ApiResult.Error("Sai email hoặc password")

        } catch (e: Exception) {

            ApiResult.Error("Unknown error")
        }
    }
}