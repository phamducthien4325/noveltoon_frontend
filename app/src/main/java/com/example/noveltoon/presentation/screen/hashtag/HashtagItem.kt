package com.example.noveltoon.presentation.screen.hashtag

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noveltoon.domain.model.Hashtag

@Composable
fun HashtagItem(
    hashtag: Hashtag
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {

        Text(
            text = "#${hashtag.name}",
            style = MaterialTheme.typography.bodyLarge
        )
    }

    HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
}