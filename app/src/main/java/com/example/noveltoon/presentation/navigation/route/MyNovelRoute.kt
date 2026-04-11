package com.example.noveltoon.presentation.navigation.route

sealed class MyNovelRoute(val route: String) {
    object MyNovels : MyNovelRoute("myNovels")

    object CreateNovel : MyNovelRoute("createNovel")

    object CreateChapter: MyNovelRoute("createChapter")
}