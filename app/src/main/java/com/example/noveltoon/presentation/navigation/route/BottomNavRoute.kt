package com.example.noveltoon.presentation.navigation.route

sealed class BottomNavRoute(val route: String) {

    data object Home : BottomNavRoute("home")

    data object Hashtag: BottomNavRoute("hashtag")


    data object Follow: BottomNavRoute("follow")

    data object Library: BottomNavRoute("library")

    data object Profile: BottomNavRoute("profile")
}