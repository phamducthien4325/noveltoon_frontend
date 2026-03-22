package com.example.noveltoon.presentation.screen.hashtag

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.noveltoon.presentation.components.SearchSection

@Composable
fun HashtagScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        SearchSection()

        HotTabBar()

        Row(
            modifier = Modifier.fillMaxSize()
        ) {

            CategoryList()

            HashtagList()
        }
    }
}