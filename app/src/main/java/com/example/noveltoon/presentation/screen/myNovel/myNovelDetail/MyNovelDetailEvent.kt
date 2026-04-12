package com.example.noveltoon.presentation.screen.myNovel.myNovelDetail

sealed class MyNovelDetailEvent {

    sealed class CreateChapterEvent : MyNovelDetailEvent() {
        data class Success(val chapterId: String) : MyNovelDetailEvent()
    }
}