package com.example.noveltoon.presentation.screen.myNovel.creatNovel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noveltoon.core.utils.ActionState
import com.example.noveltoon.core.utils.runUseCase
import com.example.noveltoon.domain.usecase.CreateNovelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNovelViewModel @Inject constructor(
    private val createNovelUseCase: CreateNovelUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(CreateNovelState())
    val uiState = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<CreateNovelScreenEvent>()
    val event = _event.asSharedFlow()

    fun updateTitleText(titleText: String) {
        _uiState.update {
            it.copy(titleText = titleText)
        }
    }

    fun updateDescriptionText(descriptionText: String) {
        _uiState.update {
            it.copy(descriptionText = descriptionText)
        }
    }

    fun toggleTitleSheet() {
        _uiState.update {
            it.copy(showTitleSheet = !it.showTitleSheet)
        }
    }

    fun toggleDescriptionSheet() {
        _uiState.update {
            it.copy(showDescriptionSheet = !it.showDescriptionSheet)
        }
    }

    fun createNovel(title: String, description: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(createState = ActionState.Loading)
            }

            val result = runUseCase {
                createNovelUseCase(
                    uiState.value.titleText,
                    uiState.value.descriptionText
                )
            }

            _uiState.update {
                it.copy(createState = result)
            }

            if (result is ActionState.Success) {
                _event.emit(CreateNovelScreenEvent.CreateNovelEvent.Success)
            }
        }
    }
}