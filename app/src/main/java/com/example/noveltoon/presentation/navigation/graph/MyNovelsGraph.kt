package com.example.noveltoon.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.noveltoon.presentation.navigation.route.MyNovelsRoute
import com.example.noveltoon.presentation.screen.myNovel.MyNovelsScreen
import com.example.noveltoon.presentation.screen.myNovel.creatNovel.CreateNovelScreen
import com.example.noveltoon.presentation.screen.myNovel.createChapter.EditingChapterScreen
import com.example.noveltoon.presentation.screen.myNovel.myNovelDetail.MyNovelDetailScreen

fun NavGraphBuilder.myNovelsGraph(
    navController: NavHostController,
) {

    composable(
        route = MyNovelsRoute.MyNovels.route,
    ) {
        MyNovelsScreen(
            savedStateHandle = navController.currentBackStackEntry?.savedStateHandle,
            onNavigateToCreateNovel = {
                navController.navigate(MyNovelsRoute.CreateNovels.route)
            },
            onNavigateToMyNovelsDetail = { novelId ->
                navController.navigate(MyNovelsRoute.MyNovelDetail.createRoute(novelId))
            }
        )
    }

    composable(
        route = MyNovelsRoute.CreateNovels.route
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

    composable(
        route = MyNovelsRoute.EditingChapter.route,
        arguments = listOf(
            navArgument("novelId") {
                type = NavType.StringType
            },
            navArgument("chapterId") {
                type = NavType.StringType
            }
        )
    ) {
        EditingChapterScreen()
    }

    composable(
        route = MyNovelsRoute.MyNovelDetail.route,
        arguments = listOf(navArgument("novelId") { type = NavType.StringType })
    ) {
        MyNovelDetailScreen(
            onNavigateToEditingChapter = { novelId, chapterId ->
                navController.navigate(
                    MyNovelsRoute.EditingChapter.route
                )
            }
        )
    }
}