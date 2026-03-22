package com.example.noveltoon.presentation.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeTopBar(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {

    val tabs = listOf("Đề xuất", "Tiểu thuyết", "Truyện chat")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth()
    ) {

        tabs.forEachIndexed { index, title ->

            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                },
                text = { Text(title) }
            )
        }
    }
}