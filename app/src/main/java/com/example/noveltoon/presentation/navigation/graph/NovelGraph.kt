package com.example.noveltoon.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.noveltoon.presentation.navigation.route.NovelRoute
import com.example.noveltoon.presentation.screen.reader.novelDetail.NovelDetailScreen

fun NavGraphBuilder.novelGraph(
    navController: NavHostController,
) {

    composable(
        route = NovelRoute.NovelDetail.route,
        arguments = listOf(navArgument("novelId") { type = NavType.StringType })
    ) {
//        val viewModel: NovelDetailViewModel = hiltViewModel()
        NovelDetailScreen()
    }
}