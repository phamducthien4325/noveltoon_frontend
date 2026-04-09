package com.example.noveltoon.presentation.screen.reader.chapterDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ChapterDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: ChapterDetailViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val uiState by viewModel.uiState.collectAsState()
        Text("Chapter Detail Screen ${uiState.chapterId} of novelId: ${uiState.novelId}")
    }
}