package com.example.noveltoon.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MainBottomBar(
    navController: NavHostController
) {

    val items = listOf(
        "home",
        "hashtag",
        "follow",
        "library",
        "profile"
    )

    NavigationBar {

        items.forEach { route ->

            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate(route)
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = route
                    )
                },
                label = {
                    Text(route)
                }
            )

        }
    }
}