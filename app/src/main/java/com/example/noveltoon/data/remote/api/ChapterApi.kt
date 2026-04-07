package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.ChapterDto
import com.example.noveltoon.data.remote.responseDTO.PageResponseDto
import com.example.noveltoon.data.remote.responseDTO.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChapterApi {

    @GET("novels/{novelId}/chapters")
    suspend fun getNovelChapters(
        @Path("novelId") novelId: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ResponseDto<PageResponseDto<ChapterDto>>
}