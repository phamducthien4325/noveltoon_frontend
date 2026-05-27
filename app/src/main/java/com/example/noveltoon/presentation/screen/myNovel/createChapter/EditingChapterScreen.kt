package com.example.noveltoon.presentation.screen.myNovel.createChapter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Redo
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noveltoon.core.helper.countWords

@Composable
fun EditingChapterScreen(
    modifier: Modifier = Modifier,
    viewModel: EditingChapterViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CreateNovelTopBar(
                chapterLength = countWords(uiState.chapterContent),
                onBack = {},
                onNext = {}
            )
        },
        bottomBar = {
            CreateChapterBottomBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {

//            Text(
//                text = uiState.chapterTitle.ifEmpty { "Nhập tên chương" },
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .padding(horizontal = 16.dp, vertical = 12.dp)
//            )

            TextField(
                value = uiState.chapterTitle,
                onValueChange = { viewModel.updateChapterTitle(it) },
                placeholder = {
                    Text(
                        text = "Nhập tên chương",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            TextField(
                value = uiState.chapterContent,
                onValueChange = { viewModel.updateChapterContent(it) },
                placeholder = {
                    Text("Số từ trong một chương đề xuất 1000-2000 từ.")
                },
                modifier = Modifier
                    .fillMaxSize(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun CreateNovelTopBar(
    chapterLength: Int,
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }

        Text(
            text = "$chapterLength/700 chữ",
            modifier = Modifier.weight(1f),
            color = Color.Gray
        )

        IconButton(onClick = { /* undo */ }) {
            Icon(Icons.AutoMirrored.Filled.Undo, contentDescription = "Undo")
        }

        IconButton(onClick = { /* redo */ }) {
            Icon(Icons.AutoMirrored.Filled.Redo, contentDescription = "Redo")
        }

        Button(
            onClick = onNext,
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Tiếp theo")
        }
    }
}

@Composable
fun CreateChapterBottomBar() {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Person, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Settings, contentDescription = null) }
        )
    }
}