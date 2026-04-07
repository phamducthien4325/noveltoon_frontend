package com.example.noveltoon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,

    val username: String,

    val avatar: String,

    val email: String,

    val role: String
)