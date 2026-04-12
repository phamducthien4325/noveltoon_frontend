package com.example.noveltoon.presentation.screen.reader.novelDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noveltoon.domain.model.Chapter


@Composable
fun ChapterItem(
    chapter: Chapter,
    onNavigateToChapterDetail: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onNavigateToChapterDetail()
            }
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = chapter.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = chapter.chapterNumber.toString(),
//                    color = Color.Gray,
//                    fontSize = 13.sp,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                    lineHeight = 18.sp
//                )
            }
        }
    }
}