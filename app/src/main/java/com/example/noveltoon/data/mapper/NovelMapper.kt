package com.example.noveltoon.data.mapper

import com.example.noveltoon.data.remote.dto.NovelDto
import com.example.noveltoon.domain.model.Novel

fun NovelDto.toDomain(): Novel {
    return Novel(
        id = id,
        title = title,
        description = description?: "No description"
    )
}