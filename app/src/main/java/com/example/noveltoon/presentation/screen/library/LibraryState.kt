package com.example.noveltoon.presentation.screen.library

data class LibraryState(
    val selectedTabIndex: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
)
