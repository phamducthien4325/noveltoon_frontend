package com.example.noveltoon

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.noveltoon.core.ui.theme.AppTheme
import com.example.noveltoon.presentation.navigation.graph.RootNavHost

@Composable
fun MainApp() {
    val navController = rememberNavController()

    AppTheme {
        RootNavHost(navController = navController)
    }
}
