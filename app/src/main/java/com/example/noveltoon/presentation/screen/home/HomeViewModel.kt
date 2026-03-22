//package com.example.noveltoon.presentation.screen.home
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.noveltoon.domain.usecase.GetNovelsUseCase
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.*
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class HomeViewModel @Inject constructor(
//    private val getNovelsUseCase: GetNovelsUseCase
//) : ViewModel() {
//
//    private val _state = MutableStateFlow(HomeUiState())
//    val state = _state.asStateFlow()
//
//    init {
//        fetchNovels()
//    }
//
//    private fun fetchNovels() {
//        viewModelScope.launch {
//            _state.value = HomeUiState(isLoading = true)
//
//            try {
//                val data = getNovelsUseCase()
//
//                _state.value = HomeUiState(
//                    novels = data
//                )
//
//            } catch (e: Exception) {
//                _state.value = HomeUiState(
//                    error = e.message
//                )
//            }
//        }
//    }
//}