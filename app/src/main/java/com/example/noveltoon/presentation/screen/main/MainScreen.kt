package com.example.noveltoon.presentation.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.noveltoon.presentation.navigation.graph.MainNavGraph
import com.example.noveltoon.presentation.screen.home.HomeTopBar

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding  ->

        MainNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}