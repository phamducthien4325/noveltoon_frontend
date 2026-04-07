package com.example.noveltoon.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.noveltoon.presentation.navigation.route.AuthRoute
import com.example.noveltoon.presentation.navigation.route.NovelRoute
import com.example.noveltoon.presentation.screen.reader.NovelDetailScreen

fun NavGraphBuilder.novelGraph(
    navController: NavHostController,
) {

    composable(NovelRoute.NovelDetail.route) {
        NovelDetailScreen()
    }
}