package com.example.noveltoon.presentation.screen.profile

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val icon: ImageVector,
    val title: String,
    val trailingText: String? = null,
    val hasNotification: Boolean = false,
    val badgeImage: Int? = null // Dùng cho các icon sự kiện bên phải
)