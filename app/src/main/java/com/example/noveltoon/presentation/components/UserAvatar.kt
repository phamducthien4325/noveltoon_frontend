package com.example.noveltoon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlin.math.absoluteValue

@Composable
fun UserAvatar(
    avatarUrl: String?,
    username: String,
    modifier: Modifier = Modifier
) {

    if (!avatarUrl.isNullOrBlank()) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(avatarUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = modifier.clip(CircleShape),
            contentScale = ContentScale.Crop
        )

    } else {

        Box(
            modifier = modifier
                .clip(CircleShape)
                .background(getAvatarColor(username)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = getAvatarLetter(username),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

fun getAvatarLetter(name: String): String {
    return name.trim().firstOrNull()?.uppercase() ?: "?"
}

fun getAvatarColor(name: String): Color {
    val colors = listOf(
        Color(0xFFEF5350),
        Color(0xFFAB47BC),
        Color(0xFF42A5F5),
        Color(0xFF26A69A),
        Color(0xFFFFA726)
    )

    val index = name.hashCode().absoluteValue % colors.size
    return colors[index]
}