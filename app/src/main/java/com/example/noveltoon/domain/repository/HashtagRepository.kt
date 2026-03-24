package com.example.noveltoon.domain.repository

import com.example.noveltoon.domain.model.Hashtag

interface HashtagRepository {
    suspend fun getHashtags(): List<Hashtag>
}