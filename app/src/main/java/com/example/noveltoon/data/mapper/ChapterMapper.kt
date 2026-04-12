package com.example.noveltoon.data.mapper

import com.example.noveltoon.data.remote.dto.ChapterDto
import com.example.noveltoon.data.remote.dto.NovelDto
import com.example.noveltoon.domain.model.Chapter
import com.example.noveltoon.domain.model.Novel

fun ChapterDto.toDomain(): Chapter {
    return Chapter(
        id = id,
        title = title,
        content = content
    )
}