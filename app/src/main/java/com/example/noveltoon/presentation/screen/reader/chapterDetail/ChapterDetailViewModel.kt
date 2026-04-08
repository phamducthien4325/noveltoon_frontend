package com.example.noveltoon.presentation.screen.reader.chapterDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.domain.usecase.GetChaptersUseCase
import com.example.noveltoon.presentation.screen.reader.novelDetail.NovelDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChapterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChapterDetailState())
    private val novelId: String = checkNotNull(savedStateHandle["novelId"])
    private val chapterId: String = checkNotNull(savedStateHandle["chapterId"])


    init {
        _uiState.update {
            it.copy(novelId = novelId, chapterId = chapterId)
        }
    }

    val uiState = _uiState.asStateFlow()
}