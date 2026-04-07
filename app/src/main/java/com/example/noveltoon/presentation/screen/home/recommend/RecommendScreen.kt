package com.example.noveltoon.presentation.screen.home.recommend

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun RecommendScreen(
    viewModel: RecommendViewModel = hiltViewModel(),
    onNavigateToDetail: (novelId: String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val novels = viewModel.novels.collectAsLazyPagingItems()

    SuggestedNovelsSection(
        novels = novels,
        onNavigateToDetail = onNavigateToDetail,
        modifier = Modifier.fillMaxSize()
    )
}