package com.example.noveltoon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noveltoon.presentation.navigation.graph.novelGraph
import com.example.noveltoon.presentation.navigation.route.MainRoute
import com.example.noveltoon.presentation.navigation.route.NovelRoute
import com.example.noveltoon.presentation.screen.follow.FollowScreen
import com.example.noveltoon.presentation.screen.hashtag.HashtagScreen
import com.example.noveltoon.presentation.screen.home.HomeScreen
import com.example.noveltoon.presentation.screen.library.LibraryScreen
import com.example.noveltoon.presentation.screen.profile.ProfileScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = MainRoute.Home.route,
        modifier = modifier
    ) {

        composable(MainRoute.Home.route) {
            HomeScreen(
                onNavigateToDetail = { novelId ->
                    navController.navigate(NovelRoute.NovelDetail.createRoute(novelId))
                }
            )
        }

        composable(MainRoute.Hashtag.route) {
            HashtagScreen()
        }

        composable(MainRoute.Follow.route) {
            FollowScreen()
        }

        composable(MainRoute.Library.route) {
            LibraryScreen()
        }

        composable(MainRoute.Profile.route) {
            ProfileScreen()
        }

        novelGraph(navController)
    }
}