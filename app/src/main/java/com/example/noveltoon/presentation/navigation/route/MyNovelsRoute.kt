package com.example.noveltoon.presentation.navigation.route

sealed class MyNovelsRoute(val route: String) {
    object MyNovels : MyNovelsRoute("myNovels")

    object CreateNovels : MyNovelsRoute("createNovel")

    object EditingChapter: MyNovelsRoute("editingChapter/{novelId}/{chapterId}") {
        fun createRoute(novelId: String, chapterId: String) =
            "editingChapter/$novelId/$chapterId"
    }

    object MyNovelDetail : MyNovelsRoute("editing/{novelId}") {
        fun createRoute(novelId: String) = "editing/$novelId"
    }
}