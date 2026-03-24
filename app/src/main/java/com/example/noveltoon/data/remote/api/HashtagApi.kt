package com.example.noveltoon.data.remote.api

import com.example.noveltoon.data.remote.dto.HashtagDto
import com.example.noveltoon.data.remote.responseDTO.PageResponseDto
import com.example.noveltoon.data.remote.responseDTO.ResponseDto
import retrofit2.http.GET

interface HashtagApi {

    @GET("hashtags")
    suspend fun getHashtags(): ResponseDto<PageResponseDto<HashtagDto>>
}