package com.example.noveltoon.presentation.screen.home.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.domain.usecase.GetHashtagsUseCase
import com.example.noveltoon.domain.usecase.GetNovelsUseCase
import com.example.noveltoon.presentation.screen.hashtag.HashtagState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(
    private val getNovelsUseCase: GetNovelsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecommendState())
    val uiState = _uiState.asStateFlow()
    val novels = getNovelsUseCase()
        .cachedIn(viewModelScope)
}