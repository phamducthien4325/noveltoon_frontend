package com.example.noveltoon.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.noveltoon.presentation.navigation.route.MyNovelRoute
import com.example.noveltoon.presentation.navigation.route.NovelRoute
import com.example.noveltoon.presentation.screen.myNovel.MyNovelScreen
import com.example.noveltoon.presentation.screen.reader.chapterDetail.ChapterDetailScreen
import com.example.noveltoon.presentation.screen.reader.novelDetail.NovelDetailScreen

fun NavGraphBuilder.myNovelGraph(
    navController: NavHostController,
) {

    composable(
        route = MyNovelRoute.MyNovels.route,
    ) {
        MyNovelScreen()
    }
}