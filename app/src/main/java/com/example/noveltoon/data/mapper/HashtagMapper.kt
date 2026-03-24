package com.example.noveltoon.data.mapper

import com.example.noveltoon.data.remote.dto.HashtagDto
import com.example.noveltoon.domain.model.Hashtag

fun HashtagDto.toDomain(): Hashtag {
    return Hashtag(
        id = id,
        name = name,
        description = description?: "No description"
    )
}