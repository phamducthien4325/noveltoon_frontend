package com.example.noveltoon.presentation.navigation.route

sealed class AuthRoute(val route: String) {
    data object Register: AuthRoute("register")

    data object Login: AuthRoute("login")
}