package com.example.noveltoon.data.remote.responseDTO

data class PageResponseDto<DTO>(
    val items: List<DTO>,
    val page: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int
)