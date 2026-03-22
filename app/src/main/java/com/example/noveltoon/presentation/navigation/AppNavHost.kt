package com.example.noveltoon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noveltoon.presentation.navigation.graph.RootNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {
    RootNavGraph(
        navController = navController
    )
}