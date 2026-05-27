package com.example.noveltoon.data.remote.dto

data class ChapterDto(
    val id: String,
    val title: String,
    val content: String,
)

data class CreateDraftRequest(
    val novelId: String,
)

data class UpdateDraftRequest(
    val title: String,
    val content: String,
)