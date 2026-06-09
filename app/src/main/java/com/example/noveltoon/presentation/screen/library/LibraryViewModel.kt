package com.example.noveltoon.presentation.screen.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.domain.usecase.GetFollowedNovelsUseCase
import com.example.noveltoon.domain.usecase.GetReadingHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    getFollowedNovelsUseCase: GetFollowedNovelsUseCase,
    getReadingHistoryUseCase: GetReadingHistoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LibraryState())
    val uiState = _uiState.asStateFlow()

    val followedNovels = getFollowedNovelsUseCase()
        .cachedIn(viewModelScope)

    val readingHistory = getReadingHistoryUseCase()
        .cachedIn(viewModelScope)

    fun setTabIndex(index: Int) {
        _uiState.update { it.copy(selectedTabIndex = index) }
    }
}
