package com.example.noveltoon.core.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.Color
private val LightColors = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Background,
    surface = Surface,
    error = Error,
    onPrimary = Color.White,
    onBackground = TextPrimary
)

private val DarkColors = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    error = Error,
    onPrimary = Color.White,
    onBackground = Color.White
)

@Composable
fun NoveltoonTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}