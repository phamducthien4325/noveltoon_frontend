package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.UserResponse
import com.example.noveltoon.data.remote.responseDTO.PageResponseDto
import com.example.noveltoon.data.remote.responseDTO.ResponseDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
    @GET("users/following")
    suspend fun getFollowingAuthors(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ResponseDto<PageResponseDto<UserResponse>>

    @POST("users/follow/{authorId}")
    suspend fun followAuthor(
        @Path("authorId") authorId: String
    ): ResponseDto<Unit>

    @DELETE("users/follow/{authorId}")
    suspend fun unfollowAuthor(
        @Path("authorId") authorId: String
    ): ResponseDto<Unit>
}
