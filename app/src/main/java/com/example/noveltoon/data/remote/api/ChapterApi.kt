package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.ChapterDto
import com.example.noveltoon.data.remote.dto.CreateDraftRequest
import com.example.noveltoon.data.remote.dto.UpdateDraftRequest
import com.example.noveltoon.data.remote.responseDTO.PageResponseDto
import com.example.noveltoon.data.remote.responseDTO.ResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ChapterApi {
    @GET("novels/{novelId}/chapters")
    suspend fun getNovelChapters(
        @Path("novelId") novelId: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ResponseDto<PageResponseDto<ChapterDto>>

    @POST("chapters/drafts")
    suspend fun createDraft(
        @Body request: CreateDraftRequest
    ): ResponseDto<ChapterDto>

    @PUT("chapters/drafts/{chapterId}")
    suspend fun updateDraft(
        @Path("chapterId") chapterId: String,
        @Body request: UpdateDraftRequest
    ): ResponseDto<ChapterDto>
}