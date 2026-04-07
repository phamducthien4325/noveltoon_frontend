package com.example.noveltoon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noveltoon.domain.model.Novel

//@Composable
//fun NovelItem(
//    novel: Novel,
//    onClick: (String) -> Unit
//) {
//    Card(
//        onClick = { onClick(novel.id) }
//    ) {
//        Text(text = novel.title)
//    }
//}

@Composable
fun NovelItem(
    novel: Novel,
    onNavigateToDetail: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onNavigateToDetail()
            }
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