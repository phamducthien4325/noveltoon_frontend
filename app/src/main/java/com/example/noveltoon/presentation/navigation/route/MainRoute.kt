package com.example.noveltoon.presentation.navigation.route

sealed class MainRoute(val route: String) {

    data object Home : MainRoute("home")

    data object Hashtag: MainRoute("hashtag")

    data object Follow: MainRoute("follow")

    data object Library: MainRoute("library")

    data object Profile: MainRoute("profile")
}