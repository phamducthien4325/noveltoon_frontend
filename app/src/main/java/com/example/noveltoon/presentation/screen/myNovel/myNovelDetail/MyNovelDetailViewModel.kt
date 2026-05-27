package com.example.noveltoon.presentation.screen.myNovel.myNovelDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noveltoon.core.utils.ActionState
import com.example.noveltoon.core.utils.runUseCase
import com.example.noveltoon.domain.usecase.CreateDraftUseCase
import com.example.noveltoon.domain.usecase.GetChaptersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyNovelDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getChapterUseCase: GetChaptersUseCase,
    private val createDraftUseCase: CreateDraftUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MyNovelDetailState())
    private val novelId: String = checkNotNull(savedStateHandle["novelId"])

    private val _event = MutableSharedFlow<MyNovelDetailEvent>()
    val event = _event.asSharedFlow()

    init {
        _uiState.update {
            it.copy(novelId = novelId)
        }
    }

    val uiState = _uiState.asStateFlow()

    val chapters = getChapterUseCase(novelId)
        .cachedIn(viewModelScope)

    fun createDraft() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(createChapterState = ActionState.Loading)
            }

            val result = runUseCase {
                createDraftUseCase(
                    novelId = novelId
                )
            }
            println("Success 1")


            _uiState.update {
                it.copy(createChapterState = result)
            }
            println("Success2")
            println(result)

            if (result is ActionState.Success) {
                _event.emit(MyNovelDetailEvent.CreateChapterEvent.Success(result.data.id))
            }
        }
    }
}