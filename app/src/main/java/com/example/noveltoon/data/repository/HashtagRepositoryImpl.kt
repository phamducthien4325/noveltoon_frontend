package com.example.noveltoon.data.repository

import com.example.noveltoon.data.mapper.toDomain
import com.example.noveltoon.data.remote.api.HashtagApi
import com.example.noveltoon.domain.model.Hashtag
import com.example.noveltoon.domain.repository.HashtagRepository
import javax.inject.Inject

class HashtagRepositoryImpl @Inject constructor(
    private val api: HashtagApi
) : HashtagRepository {

    override suspend fun getHashtags(): List<Hashtag> {
        return api.getHashtags().data.items.map { it.toDomain() }
    }
}