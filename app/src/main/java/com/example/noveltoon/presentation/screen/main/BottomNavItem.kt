package com.example.noveltoon.presentation.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    val route: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector,
    val label: String
) {

    object Home : BottomBarItem(
        route = "home",
        icon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        label = "Home"
    )

    object Hashtag : BottomBarItem(
        route = "hashtag",
        icon = Icons.Outlined.Tag,
        selectedIcon = Icons.Filled.Tag,
        label = "Hashtag"
    )

    object Follow : BottomBarItem(
        route = "follow",
        icon = Icons.Outlined.People,
        selectedIcon = Icons.Filled.People,
        label = "Follow"
    )

    object Library : BottomBarItem(
        route = "library",
        icon = Icons.Outlined.BookmarkBorder,
        selectedIcon = Icons.Filled.Bookmark,
        label = "Library"
    )

    object Profile : BottomBarItem(
        route = "profile",
        icon = Icons.Outlined.Person,
        selectedIcon = Icons.Filled.Person,
        label = "Profile"
    )
}

val bottomBarItems = listOf(
    BottomBarItem.Home,
    BottomBarItem.Hashtag,
    BottomBarItem.Follow,
    BottomBarItem.Library,
    BottomBarItem.Profile
)