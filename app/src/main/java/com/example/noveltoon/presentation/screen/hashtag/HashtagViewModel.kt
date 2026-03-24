package com.example.noveltoon.presentation.screen.hashtag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noveltoon.domain.usecase.GetHashtagsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HashtagViewModel @Inject constructor(
    private val getHashtagsUseCase: GetHashtagsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HashtagState())
    val uiState: StateFlow<HashtagState> = _uiState

    fun loadHashtags() {
        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true) }

            try {

                val hashtags = getHashtagsUseCase()

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        hashtags = hashtags
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