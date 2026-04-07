package com.example.noveltoon.data.remote.dto

data class UserResponse(
    val avatar: String?,
    val email: String,
    val id: String,
    val role: String,
    val username: String
)