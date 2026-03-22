package com.example.noveltoon.presentation.screen.hashtag

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HashtagItem(tag: Hashtag) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = tag.image,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {

            Text(
                text = "#${tag.name}",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${tag.works} works",
                color = Color.Gray
            )
        }
    }
}