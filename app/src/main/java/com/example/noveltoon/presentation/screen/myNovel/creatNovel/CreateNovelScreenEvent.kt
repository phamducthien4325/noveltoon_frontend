package com.example.noveltoon.presentation.screen.myNovel.creatNovel

sealed class CreateNovelScreenEvent {
    sealed class ShowTitleSheetEvent : CreateNovelScreenEvent() {
        data class ShowError(val message: String) : ShowTitleSheetEvent()
    }

    sealed class CreateNovelEvent : CreateNovelScreenEvent() {
        data object Success : CreateNovelEvent()
    }
}