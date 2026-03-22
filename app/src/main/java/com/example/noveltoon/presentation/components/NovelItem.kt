package com.example.noveltoon.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.noveltoon.domain.model.Novel

@Composable
fun NovelItem(
    novel: Novel,
    onClick: (String) -> Unit
) {
    Card(
        onClick = { onClick(novel.id) }
    ) {
        Text(text = novel.title)
    }
}