package com.example.noveltoon.presentation.screen.home.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noveltoon.domain.usecase.GetHashtagsUseCase
import com.example.noveltoon.domain.usecase.GetNovelsUseCase
import com.example.noveltoon.presentation.screen.hashtag.HashtagState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(
    private val getNovelUseCase: GetNovelsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecommendState())

    val uiState: StateFlow<RecommendState> = _uiState

    fun loadNovels() {
        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true) }

            try {

                val novels = getNovelUseCase()

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        novels = novels
                    )
                }

            } catch (e: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }
}