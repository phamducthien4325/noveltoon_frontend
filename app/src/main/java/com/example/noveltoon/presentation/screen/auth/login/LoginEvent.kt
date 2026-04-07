package com.example.noveltoon.presentation.screen.auth.login

sealed class LoginEvent {
    data object NavigateToHome : LoginEvent()
    data class ShowError(val message: String) : LoginEvent()
}