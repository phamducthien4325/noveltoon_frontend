package com.example.noveltoon.data.repository

import com.example.noveltoon.data.remote.api.NovelApi
import com.example.noveltoon.domain.model.Novel
import com.example.noveltoon.domain.repository.NovelRepository

class NovelRepositoryImpl(
    private val api: NovelApi
) : NovelRepository {

    override suspend fun getNovels(): List<Novel> {
        return api.getNovels().map {
            Novel(
                id = it.id,
                title = it.title,
                coverUrl = it.coverUrl
            )
        }
    }
}