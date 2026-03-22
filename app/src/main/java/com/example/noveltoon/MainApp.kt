package com.example.noveltoon

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.noveltoon.core.ui.theme.NoveltoonTheme
import com.example.noveltoon.presentation.navigation.AppNavHost

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NoveltoonTheme {
        AppNavHost(navController = navController)
    }
}
