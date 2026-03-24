package com.example.noveltoon.data.remote.responseDTO

data class ResponseDto<DTO>(
    val message: String,
    val data: DTO
)