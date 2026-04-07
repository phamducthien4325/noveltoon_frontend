package com.example.noveltoon.data.mapper

import com.example.noveltoon.data.remote.dto.LoginResponse
import com.example.noveltoon.domain.model.AuthToken

fun LoginResponse.toDomain(): AuthToken {
    return AuthToken(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toDomain()
    )
}