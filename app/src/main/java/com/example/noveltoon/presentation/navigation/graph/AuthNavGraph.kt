package com.example.noveltoon.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.noveltoon.presentation.navigation.route.AuthRoute
import com.example.noveltoon.presentation.navigation.route.RootRoute
import com.example.noveltoon.presentation.screen.auth.login.LoginScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
) {

    composable(AuthRoute.Login.route) {
        LoginScreen(
            onLoginSuccess = {
                navController.navigate(RootRoute.MainGraph.route) {
                    popUpTo(RootRoute.AuthGraph.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}