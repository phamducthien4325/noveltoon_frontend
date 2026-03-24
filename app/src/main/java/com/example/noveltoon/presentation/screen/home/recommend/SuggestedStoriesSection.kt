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
import com.example.noveltoon.domain.model.Novel

@Composable
fun SuggestedNovelsSection(novels: List<Novel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // --- Header: Có Thể Bạn Sẽ Thích ---
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


        // --- List of Novels ---
        items(novels) { novel ->
            NovelItem(novel)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun NovelItem(novel: Novel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        // Ảnh bìa truyện
        Box(
            modifier = Modifier
                .width(90.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        ) {
            // Thay bằng AsyncImage (Coil) nếu bạn load từ URL
            // Image(painter = ..., contentScale = ContentScale.Crop)

//            if (novel.isEnd) {
//                Box(
//                    modifier = Modifier
//                        .background(Color(0xFFFFA500))
//                        .padding(horizontal = 4.dp, vertical = 2.dp)
//                ) {
//                    Text("END", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
//                }
//            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Thông tin truyện
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = novel.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = novel.description,
                    color = Color.Gray,
                    fontSize = 13.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp
                )
            }

//            Row(verticalAlignment = Alignment.CenterVertically) {
//                // Icon lửa hoặc biểu tượng view
//                Text(
//                    text = "🔥 ${novel.views}",
//                    color = Color.Gray,
//                    fontSize = 12.sp
//                )
//                Spacer(modifier = Modifier.width(12.dp))
//                Text(
//                    text = novel.category,
//                    color = Color.Gray,
//                    fontSize = 12.sp
//                )
//            }
        }
    }
}