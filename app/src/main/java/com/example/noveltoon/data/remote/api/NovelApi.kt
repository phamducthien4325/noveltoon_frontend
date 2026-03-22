package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.NovelDto
import retrofit2.http.GET

interface NovelApi {

    @GET("novels")
    suspend fun getNovels(): List<NovelDto>
}