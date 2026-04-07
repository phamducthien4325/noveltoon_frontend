package com.example.noveltoon.data.mapper

import com.example.noveltoon.data.local.entity.UserEntity
import com.example.noveltoon.data.remote.dto.UserResponse
import com.example.noveltoon.domain.model.User

fun UserResponse.toDomain(): User {
    return User(
        avatar = avatar ?: "",
        email = email,
        id = id,
        role = role,
        username = username
    )
}

fun UserResponse.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        username = username,
        avatar = avatar ?: "",
        email = email,
        role = role
    )
}