package com.example.noveltoon.presentation.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noveltoon.presentation.navigation.route.MainRoute
import com.example.noveltoon.presentation.screen.follow.FollowScreen
import com.example.noveltoon.presentation.screen.hashtag.HashtagScreen
import com.example.noveltoon.presentation.screen.home.HomeScreen
import com.example.noveltoon.presentation.screen.library.LibraryScreen
import com.example.noveltoon.presentation.screen.main.MainScreen
import com.example.noveltoon.presentation.screen.profile.ProfileScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = MainRoute.Home.route,
        modifier = modifier
    ) {

        composable(MainRoute.Home.route) {
            HomeScreen()
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
    }
}