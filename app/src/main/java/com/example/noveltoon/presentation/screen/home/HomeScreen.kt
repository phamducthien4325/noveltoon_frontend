package com.example.noveltoon.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.noveltoon.presentation.screen.home.recommend.RecommendScreen

@Composable
fun HomeScreen() {

    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            HomeTopBar(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            when (selectedTabIndex) {

                0 -> RecommendScreen()

                1 -> NovelScreen()

                2 -> ChatStoryScreen()
            }
        }
    }
}