package com.example.noveltoon.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.noveltoon.presentation.screen.home.recommend.RecommendScreen
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onNavigateToDetail: (novelId: String) -> Unit
) {

    val pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            HomeTopBar(
                selectedTabIndex = pagerState.currentPage,
                onTabSelected = { index ->
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    ) { innerPadding ->

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(innerPadding)
        ) { page ->

            when (page) {

                0 -> RecommendScreen(onNavigateToDetail = onNavigateToDetail)

                1 -> NovelScreen()

                2 -> ChatStoryScreen()
            }
        }
    }
}