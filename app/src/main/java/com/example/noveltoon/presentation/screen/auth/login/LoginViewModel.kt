package com.example.noveltoon.presentation.screen.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noveltoon.data.remote.responseDTO.ApiResult
import com.example.noveltoon.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()

    fun updateEmail(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }

    fun login() {
        val email = _uiState.value.email
        val password = _uiState.value.password

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    loginError = null
                )
            }

            when (val result = loginUseCase(email, password)) {

                is ApiResult.Success -> {

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isLoginSuccess = true
                        )
                    }

                    _event.emit(LoginEvent.NavigateToHome)
                }

                is ApiResult.Error -> {

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            loginError = result.message
                        )
                    }
                    println("Login error: ${result.message}")
                }
            }
        }
    }

    fun staticLogin() {
        updateEmail("test@gmail.com")
        updatePassword("123456")
        val email = _uiState.value.email
        val password = _uiState.value.password

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    loginError = null
                )
            }

            when (val result = loginUseCase(email, password)) {

                is ApiResult.Success -> {

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            isLoginSuccess = true
                        )
                    }

                    _event.emit(LoginEvent.NavigateToHome)
                }

                is ApiResult.Error -> {

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            loginError = result.message
                        )
                    }
                    println("Login error: ${result.message}")
                }
            }
        }
    }

    fun toggleLoginSheet() {
        _uiState.update {
            it.copy(showLoginSheet = !it.showLoginSheet)
        }
    }
}