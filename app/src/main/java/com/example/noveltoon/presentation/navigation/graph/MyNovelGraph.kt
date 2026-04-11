package com.example.noveltoon.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.noveltoon.presentation.navigation.route.MyNovelRoute
import com.example.noveltoon.presentation.screen.myNovel.MyNovelScreen
import com.example.noveltoon.presentation.screen.myNovel.creatNovel.CreateNovelScreen
import com.example.noveltoon.presentation.screen.myNovel.createChapter.CreateChapterScreen

fun NavGraphBuilder.myNovelGraph(
    navController: NavHostController,
) {

    composable(
        route = MyNovelRoute.MyNovels.route,
    ) {
        MyNovelScreen(
            savedStateHandle = navController.currentBackStackEntry?.savedStateHandle,
            onNavigateToCreateNovel = {
                navController.navigate(MyNovelRoute.CreateNovel.route)
            },
            onNavigateToCreateChapter = {
                navController.navigate(MyNovelRoute.CreateChapter.route)
            }
        )
    }

    composable(
        route = MyNovelRoute.CreateNovel.route
    ) {
        CreateNovelScreen(
            onCreateNovelSuccess = {
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("refresh", true)
                navController.popBackStack()
            }
        )
    }

    composable(route = MyNovelRoute.CreateChapter.route) {
        CreateChapterScreen()
    }
}