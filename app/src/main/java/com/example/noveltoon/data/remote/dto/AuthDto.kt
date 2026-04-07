package com.example.noveltoon.data.remote.dto

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    var user: UserResponse
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class RefreshRequest(
    val refreshToken: String
)

data class RefreshResponse(
    val accessToken: String,
    val refreshToken: String
)