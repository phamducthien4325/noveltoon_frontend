package com.example.noveltoon.presentation.screen.home.recommend

import com.example.noveltoon.domain.model.Hashtag
import com.example.noveltoon.domain.model.Novel

data class RecommendState(

    val isLoading: Boolean = false,
    val novels: List<Novel> = emptyList(),
    val error: String? = null
)