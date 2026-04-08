package com.example.noveltoon.presentation.screen.reader.chapterDetail

data class ChapterDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val novelId: String = "",
    val chapterId: String = ""
)