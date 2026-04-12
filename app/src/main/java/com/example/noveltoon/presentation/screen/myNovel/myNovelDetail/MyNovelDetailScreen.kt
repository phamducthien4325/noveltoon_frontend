package com.example.noveltoon.presentation.screen.myNovel.myNovelDetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.noveltoon.presentation.screen.myNovel.creatNovel.CreateNovelScreenEvent
import com.example.noveltoon.presentation.screen.reader.novelDetail.ChapterItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNovelDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MyNovelDetailViewModel = hiltViewModel(),
    onNavigateToEditingChapter: (novelId: String, chapterId: String) -> Unit,
) {
    val chapters = viewModel.chapters.collectAsLazyPagingItems()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is MyNovelDetailEvent.CreateChapterEvent.Success -> {
                    onNavigateToEditingChapter(uiState.novelId, event.chapterId)
                }
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Chi tiết", fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = { viewModel.createChapter() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF58A5FF))
            ) {
                Text("Tạo chương, bắt đầu sáng tác", color = Color.White, fontSize = 16.sp)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            StoryHeaderSection()
            HorizontalDivider(thickness = 8.dp, color = Color(0xFFF5F5F5)) // Khoảng cách xám
            TabSection()

            LazyColumn(
                modifier = modifier.padding(16.dp)
            ) {

                items(
                    count = chapters.itemCount,
                    key = { index -> chapters[index]?.id ?: index }
                ) { index ->

                    val chapter = chapters[index]

                    chapter?.let {
                        ChapterItem(it) {
                            onNavigateToEditingChapter(
                                uiState.novelId,
                                chapter.id
                            )
                        }
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

@Composable
fun StoryHeaderSection() {
    Row(modifier = Modifier.padding(16.dp)) {
        // Placeholder cho ảnh bìa
        Box(
            modifier = Modifier
                .size(width = 100.dp, height = 130.dp)
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.LightGray)
                Text("Thêm bìa", color = Color.LightGray, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text("Vĩnh Sinh", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("Đang ra  |  Đã đăng: 0 chữ", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Chờ đăng chương đầu", color = Color(0xFFFF9800), fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    border = BorderStroke(1.dp, Color(0xFF58A5FF))
                ) {
                    Text("Sửa", color = Color(0xFF58A5FF))
                }
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    border = BorderStroke(1.dp, Color(0xFF58A5FF))
                ) {
                    Text("Thống kê", color = Color(0xFF58A5FF))
                }
            }
        }
    }
}

@Composable
fun TabSection() {
    Row(modifier = Modifier.padding(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Chương(0)", fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .size(width = 20.dp, height = 3.dp)
                    .background(Color(0xFF58A5FF), CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Text("Bản nháp", color = Color.Gray)
    }
}

@Composable
fun EmptyStateSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Thay R.drawable.empty_box bằng icon thực tế của bạn
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = Color(0xFFE0E0E0)
        )
        Text("Dữ liệu trống", color = Color.Gray, fontSize = 14.sp)
    }
}