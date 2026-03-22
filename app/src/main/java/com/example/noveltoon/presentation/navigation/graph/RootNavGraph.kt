package com.example.noveltoon.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.noveltoon.presentation.navigation.route.MainRoute
import com.example.noveltoon.presentation.navigation.route.RootRoute
import com.example.noveltoon.presentation.screen.main.MainScreen

@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = RootRoute.MainGraph.route
    ) {

        navigation(
            route = RootRoute.MainGraph.route,
            startDestination = MainRoute.Home.route
            ) {
            composable(MainRoute.Home.route) {
                MainScreen()
            }
        }
//
//        composable("login") {
//            LoginScreen()
//        }
    }
}