package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.LoginRequest
import com.example.noveltoon.data.remote.dto.LoginResponse
import com.example.noveltoon.data.remote.dto.RefreshRequest
import com.example.noveltoon.data.remote.dto.RefreshResponse
import com.example.noveltoon.data.remote.responseDTO.ResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): ResponseDto<LoginResponse>

    @POST("auth/refresh")
    suspend fun refreshToken(
        @Body request: RefreshRequest
    ): Response<RefreshResponse>
}