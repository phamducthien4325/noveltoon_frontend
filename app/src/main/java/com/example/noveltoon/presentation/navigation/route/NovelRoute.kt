package com.example.noveltoon.presentation.navigation.route

sealed class NovelRoute(val route: String) {
    object NovelDetail : NovelRoute("reading/{novelId}") {
        // Hàm tiện dụng để tạo route với id
        fun createRoute(novelId: String) = "reading/$novelId"
    }
}