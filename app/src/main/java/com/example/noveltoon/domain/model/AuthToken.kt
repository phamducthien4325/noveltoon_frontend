package com.example.noveltoon.domain.model

data class AuthToken(
    val accessToken: String,
    val refreshToken: String,
    val user: User
)