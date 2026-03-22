package com.example.noveltoon.domain.repository

import com.example.noveltoon.domain.model.Novel

interface NovelRepository {
    suspend fun getNovels(): List<Novel>
}