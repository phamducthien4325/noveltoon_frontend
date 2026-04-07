package com.example.noveltoon.presentation.navigation.route

sealed class NovelRoute(val route: String) {
    data object NovelDetail: NovelRoute("reading")
}