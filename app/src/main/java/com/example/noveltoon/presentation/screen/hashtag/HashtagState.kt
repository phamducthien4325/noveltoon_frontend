package com.example.noveltoon.presentation.screen.hashtag

import com.example.noveltoon.domain.model.Hashtag

data class HashtagState(

    val isLoading: Boolean = false,
    val hashtags: List<Hashtag> = emptyList(),
    val error: String? = null
)