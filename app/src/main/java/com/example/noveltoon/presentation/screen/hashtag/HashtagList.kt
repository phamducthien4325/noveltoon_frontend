package com.example.noveltoon.presentation.screen.hashtag

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HashtagList() {

    val tags = listOf(
        Hashtag("Xuyên Không", "176274", ""),
        Hashtag("Ngược", "169318", ""),
        Hashtag("Boylove", "77321", ""),
        Hashtag("RhyCap", "61567", ""),
        Hashtag("ABO", "60454", "")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        items(tags) { tag ->
            HashtagItem(tag)
        }
    }
}