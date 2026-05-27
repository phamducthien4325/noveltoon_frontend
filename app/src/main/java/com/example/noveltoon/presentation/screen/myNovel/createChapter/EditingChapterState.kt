package com.example.noveltoon.presentation.screen.myNovel.createChapter

data class EditingChapterState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val novelId: String = "",
    val chapterId: String = "",
    var chapterContent: String = "",
    var chapterTitle: String = ""
)