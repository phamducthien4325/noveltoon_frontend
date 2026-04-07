package com.example.noveltoon.presentation.screen.home.recommend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.noveltoon.domain.model.Novel
import com.example.noveltoon.presentation.components.NovelItem

@Composable
fun SuggestedNovelsSection(
    novels: LazyPagingItems<Novel>,
    onNavigateToDetail: (novelId: String) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
//         --- Header: Có Thể Bạn Sẽ Thích ---
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color(0xFFE91E63), // Màu hồng trái tim
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Có Thể Bạn Sẽ Thích",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Thêm",
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
            count = novels.itemCount,
            key = { index -> novels[index]?.id ?: index }
        ) { index ->

            val novel = novels[index]

            novel?.let {
                NovelItem(it, onNavigateToDetail = { onNavigateToDetail(novel.id) })
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Loading khi load thêm trang
        if (novels.loadState.append is LoadState.Loading) {
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
        if (novels.loadState.append is LoadState.Error) {
            item {

                val e = novels.loadState.append as LoadState.Error

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text("Error: ${e.error.message}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { novels.retry() }) {
                        Text("Retry")
                    }
                }
            }
        }
    }

    // Loading lần đầu
    when (novels.loadState.refresh) {

        is LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is LoadState.Error -> {

            val e = novels.loadState.refresh as LoadState.Error

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("Error: ${e.error.message}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { novels.retry() }) {
                        Text("Retry")
                    }
                }
            }
        }

        else -> {}
    }
}