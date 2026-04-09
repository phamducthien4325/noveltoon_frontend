package com.example.noveltoon.presentation.navigation.route

sealed class MyNovelRoute(val route: String) {
    object MyNovels : MyNovelRoute("myNovels")
//    object NovelDetail : MyNovelRoute("reading/{novelId}") {
//        fun createRoute(novelId: String) = "reading/$novelId"
//    }
//
//    object ChapterDetail : MyNovelRoute("reading/{novelId}/{chapterId}") {
//        fun createRoute(novelId: String, chapterId: String) =
//            "reading/$novelId/$chapterId"
//    }
}