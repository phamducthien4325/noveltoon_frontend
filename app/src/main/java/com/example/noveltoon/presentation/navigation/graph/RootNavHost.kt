package com.example.noveltoon.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.noveltoon.presentation.navigation.route.AuthRoute
import com.example.noveltoon.presentation.navigation.route.RootRoute

@Composable
fun RootNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
//        startDestination = RootRoute.MainGraph.route
        startDestination = RootRoute.AuthGraph.route
    ) {

        composable(RootRoute.MainGraph.route) {
            BottomNavHost(navController)
        }

        navigation(
            route = RootRoute.AuthGraph.route,
            startDestination = AuthRoute.Login.route
        ) {
            authNavGraph(navController)
        }

        novelGraph(navController)
    }
}