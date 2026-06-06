package com.example.noveltoon.presentation.screen.reader.chapterDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noveltoon.domain.usecase.GetChapterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChapterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getChapterUseCase: GetChapterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChapterDetailState())
    val uiState = _uiState.asStateFlow()

    private val novelId: String = checkNotNull(savedStateHandle["novelId"])
    private val chapterId: String = checkNotNull(savedStateHandle["chapterId"])

    init {
        _uiState.update {
            it.copy(novelId = novelId, chapterId = chapterId)
        }
        loadChapterDetail()
    }

    fun loadChapterDetail() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val chapter = getChapterUseCase(chapterId)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        chapter = chapter,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Đã xảy ra lỗi khi tải chương truyện."
                    )
                }
            }
        }
    }

    fun changeFontSize(size: Float) {
        _uiState.update {
            it.copy(fontSize = size.coerceIn(12f, 32f))
        }
    }

}