package com.example.noveltoon.presentation.components

import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import com.example.noveltoon.domain.model.Novel

@Composable
fun NovelList(
    novels: List<Novel>,
    onClick: (String) -> Unit
) {
    LazyColumn {
        items(novels) { novel ->
            NovelItem(novel, onClick)
        }
    }
}