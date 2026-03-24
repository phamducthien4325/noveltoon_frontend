package com.example.noveltoon.data.remote.responseDTO

import com.example.noveltoon.data.remote.dto.HashtagDto

data class HashtagPageDto(
    val items: List<HashtagDto>,
    val page: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int
)