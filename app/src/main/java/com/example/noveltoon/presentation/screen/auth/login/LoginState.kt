package com.example.noveltoon.presentation.screen.auth.login

data class LoginState(
    val email: String = "",

    val password: String = "",

    val isLoading: Boolean = false,

    val emailError: String? = null,

    val passwordError: String? = null,

    val loginError: String? = null,

    val isLoginSuccess: Boolean = false,

    val showLoginSheet : Boolean = false
)
