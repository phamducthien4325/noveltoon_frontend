package com.example.noveltoon.presentation.screen.myNovel.createChapter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.noveltoon.core.utils.runUseCase
import com.example.noveltoon.domain.usecase.CreateDraftUseCase
import com.example.noveltoon.domain.usecase.UpdateDaftUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EditingChapterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val updateDaftUseCase: UpdateDaftUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(EditingChapterState())
    private val novelId: String = checkNotNull(savedStateHandle["novelId"])
    private val chapterId: String = checkNotNull(savedStateHandle["chapterId"])

    init {
        _uiState.update {
            it.copy(novelId = novelId, chapterId = chapterId)
        }
    }

    fun updateChapterContent(chapterContent: String) {
        _uiState.update {
            it.copy(chapterContent = chapterContent)
        }
    }

    fun updateChapterTitle(chapterTitle: String) {
        _uiState.update {
            it.copy(chapterTitle = chapterTitle)
        }
    }

    val uiState = _uiState.asStateFlow()

    public suspend fun saveDraft() {
        val result = runUseCase {
            updateDaftUseCase(
                chapterId = uiState.value.chapterId,
                title = uiState.value.chapterTitle,
                content = uiState.value.chapterContent
            )
        }
    }
}