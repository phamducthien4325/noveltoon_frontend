package com.example.noveltoon.presentation.screen.myNovel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.core.utils.pagingFlow
import com.example.noveltoon.domain.usecase.GetMyNovelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyNovelsViewModel @Inject constructor(
    private val getMyNovelsUseCase: GetMyNovelsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MyNovelsState())

    val uiState = _uiState.asStateFlow()

    private val refreshTrigger = MutableStateFlow(0)
    @OptIn(ExperimentalCoroutinesApi::class)
    val myNovels = pagingFlow(refreshTrigger) {
            getMyNovelsUseCase()
        }
        .cachedIn(viewModelScope)

    fun refreshMyNovels() {
        refreshTrigger.value++
    }
}