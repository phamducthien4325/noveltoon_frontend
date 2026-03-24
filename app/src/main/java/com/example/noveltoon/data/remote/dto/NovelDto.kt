package com.example.noveltoon.data.remote.dto

data class NovelDto(
    val id: String,
    val title: String,
    val description: String?,
    val status: String?,
    val views: Long
)