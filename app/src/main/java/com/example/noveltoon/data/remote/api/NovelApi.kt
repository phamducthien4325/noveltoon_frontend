package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.CreateNovelRequest
import com.example.noveltoon.data.remote.dto.NovelDto
import com.example.noveltoon.data.remote.responseDTO.PageResponseDto
import com.example.noveltoon.data.remote.responseDTO.ResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NovelApi {

    @GET("novels")
    suspend fun getNovels(
        @Query("page") page: Int,
        @Query("size") limit: Int
    ): ResponseDto<PageResponseDto<NovelDto>>

    @GET("novels/my-novels")
    suspend fun getMyNovels(
        @Query("page") page: Int,
        @Query("size") limit: Int
    ): ResponseDto<PageResponseDto<NovelDto>>

    @POST("novels")
    suspend fun createNovel(
        @Body request: CreateNovelRequest
    ): ResponseDto<NovelDto>
}