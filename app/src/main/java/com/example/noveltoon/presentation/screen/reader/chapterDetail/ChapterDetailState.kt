package com.example.noveltoon.presentation.screen.reader.chapterDetail

import com.example.noveltoon.domain.model.Chapter

data class ChapterDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val novelId: String = "",
    val chapterId: String = "",
    val chapter: Chapter? = null,
    val fontSize: Float = 18f
)