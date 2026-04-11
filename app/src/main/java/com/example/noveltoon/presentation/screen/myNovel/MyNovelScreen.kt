package com.example.noveltoon.presentation.screen.myNovel

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.noveltoon.presentation.components.NovelItem

@Composable
fun MyNovelScreen(
    modifier: Modifier = Modifier,
    viewModel: MyNovelViewModel = hiltViewModel(),
    savedStateHandle: SavedStateHandle?,
    onNavigateToCreateNovel: () -> Unit,
    onNavigateToCreateChapter: () -> Unit
) {
    val myNovels = viewModel.myNovels.collectAsLazyPagingItems()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(savedStateHandle) {
        savedStateHandle
            ?.getStateFlow("refresh", false)
            ?.collect { shouldRefresh ->

                if (shouldRefresh) {
                    viewModel.refreshMyNovels() // 🔥 Paging reload

                    savedStateHandle["refresh"] = false // reset
                }
            }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = onNavigateToCreateNovel
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = modifier.padding(
                horizontal = 16.dp,
                vertical = 32.dp
            )
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Danh sách truyện của bạn",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Text(
                            text = "Hơn",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            items(
                count = myNovels.itemCount,
                key = { index -> myNovels[index]?.id ?: index }
            ) { index ->

                val chapter = myNovels[index]

                chapter?.let {
                    NovelItem(it) {
                        onNavigateToCreateChapter()
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // Loading khi load thêm trang
            if (myNovels.loadState.append is LoadState.Loading) {
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
            if (myNovels.loadState.append is LoadState.Error) {
                item {

                    val e = myNovels.loadState.append as LoadState.Error

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text("Error: ${e.error.message}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { myNovels.retry() }) {
                            Text("Retry")
                        }
                    }
                }
            }
        }
    }



    // Loading lần đầu
    when (myNovels.loadState.refresh) {

        is LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is LoadState.Error -> {

            val e = myNovels.loadState.refresh as LoadState.Error

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("Error: ${e.error.message}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { myNovels.retry() }) {
                        Text("Retry")
                    }
                }
            }
        }

        else -> {}
    }

}