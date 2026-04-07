package com.example.noveltoon.presentation.screen.reader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.noveltoon.presentation.components.NovelItem

@Composable
fun NovelDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: NovelDetailViewModel = hiltViewModel()
) {
    val chapters = viewModel.chapters.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {

        items(
            count = chapters.itemCount,
            key = { index -> chapters[index]?.id ?: index }
        ) { index ->

            val chapter = chapters[index]

            chapter?.let {
                ChapterItem(it)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Loading khi load thêm trang
        if (chapters.loadState.append is LoadState.Loading) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

        // Error khi load thêm
        if (chapters.loadState.append is LoadState.Error) {
            item {

                val e = chapters.loadState.append as LoadState.Error

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text("Error: ${e.error.message}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { chapters.retry() }) {
                        Text("Retry")
                    }
                }
            }
        }
    }

    // Loading lần đầu
    when (chapters.loadState.refresh) {

        is LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is LoadState.Error -> {

            val e = chapters.loadState.refresh as LoadState.Error

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("Error: ${e.error.message}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { chapters.retry() }) {
                        Text("Retry")
                    }
                }
            }
        }

        else -> {}
    }
}