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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditingChapterScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    var content by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CreateNovelTopBar(
                titleLength = content.length,
                onBack = onBack,
                onNext = onNext
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

            Text(
                text = "Nhập tên chương",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )

            TextField(
                value = content,
                onValueChange = { content = it },
                placeholder = {
                    Text("Số từ trong một chương đề xuất 1000-2000 từ.")
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
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
    titleLength: Int,
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
            text = "$titleLength/700 chữ",
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