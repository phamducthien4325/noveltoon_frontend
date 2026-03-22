package com.example.noveltoon.presentation.screen.hashtag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryList() {

    val categories = listOf(
        "Xu hướng mới",
        "CP Idol",
        "LGBT",
        "Fanfic 2D",
        "Ngôn tình [Nam x Nữ]",
        "Giả tưởng/Kinh dị",
        "Tiểu Thuyết"
    )

    LazyColumn(
        modifier = Modifier
            .width(120.dp)
            .fillMaxHeight()
            .background(Color(0xFFF5F5F5))
    ) {

        items(categories) { category ->

            Text(
                text = category,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}