package com.example.noveltoon.presentation.navigation.route

sealed class NovelRoute(val route: String) {
    object NovelDetail : NovelRoute("reading/{novelId}") {
        fun createRoute(novelId: String) = "reading/$novelId"
    }

    object ChapterDetail : NovelRoute("reading/{novelId}/{chapterId}") {
        fun createRoute(novelId: String, chapterId: String) =
            "reading/$novelId/$chapterId"
    }
}