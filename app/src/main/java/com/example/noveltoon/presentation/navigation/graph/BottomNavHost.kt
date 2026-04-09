package com.example.noveltoon.presentation.navigation.graph

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noveltoon.presentation.navigation.route.BottomNavRoute
import com.example.noveltoon.presentation.navigation.route.MyNovelRoute
import com.example.noveltoon.presentation.navigation.route.NovelRoute
import com.example.noveltoon.presentation.screen.follow.FollowScreen
import com.example.noveltoon.presentation.screen.hashtag.HashtagScreen
import com.example.noveltoon.presentation.screen.home.HomeScreen
import com.example.noveltoon.presentation.screen.library.LibraryScreen
import com.example.noveltoon.presentation.screen.main.BottomBar
import com.example.noveltoon.presentation.screen.profile.ProfileScreen

@Composable
fun BottomNavHost(rootNavController: NavHostController) {
    val mainNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(mainNavController)
        }
    ) { innerPadding ->

        NavHost(
            navController = mainNavController,
            startDestination = BottomNavRoute.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(BottomNavRoute.Home.route) {
                HomeScreen(
                    onNavigateToNovelDetail = { novelId ->
                        rootNavController.navigate(NovelRoute.NovelDetail.createRoute(novelId))
                    }
                )
            }

            composable(BottomNavRoute.Hashtag.route) {
                HashtagScreen()
            }

            composable(BottomNavRoute.Follow.route) {
                FollowScreen()
            }

            composable(BottomNavRoute.Library.route) {
                LibraryScreen()
            }

            composable(BottomNavRoute.Profile.route) {
                ProfileScreen(
                    onNavigateToMyNovel = { rootNavController.navigate(MyNovelRoute.MyNovels.route) }
                )
            }

        }
    }
}