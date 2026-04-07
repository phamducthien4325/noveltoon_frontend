package com.example.noveltoon.presentation.screen.reader

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.domain.usecase.GetChaptersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NovelDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getChapterUseCase: GetChaptersUseCase
) : ViewModel() {
    private val novelId: String = checkNotNull(savedStateHandle["novelId"])

    private val _uiState = MutableStateFlow(NovelDetailState())
    val uiState = _uiState.asStateFlow()
    val chapters = getChapterUseCase(novelId)
        .cachedIn(viewModelScope)
}