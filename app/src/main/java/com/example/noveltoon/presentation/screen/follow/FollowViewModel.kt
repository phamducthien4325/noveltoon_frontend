package com.example.noveltoon.presentation.screen.follow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.domain.usecase.GetFollowingAuthorsUseCase
import com.example.noveltoon.domain.usecase.UnfollowAuthorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowViewModel @Inject constructor(
    getFollowingAuthorsUseCase: GetFollowingAuthorsUseCase,
    private val unfollowAuthorUseCase: UnfollowAuthorUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FollowState())
    val uiState = _uiState.asStateFlow()

    val authors = getFollowingAuthorsUseCase()
        .cachedIn(viewModelScope)

    fun unfollowAuthor(authorId: String) {
        viewModelScope.launch {
            try {
                unfollowAuthorUseCase(authorId)
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = e.localizedMessage ?: "Đã xảy ra lỗi")
                }
            }
        }
    }
}
