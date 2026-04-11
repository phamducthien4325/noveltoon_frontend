package com.example.noveltoon.domain.usecase

import com.example.noveltoon.core.exception.AppException
import com.example.noveltoon.data.remote.dto.CreateNovelRequest
import com.example.noveltoon.domain.model.Novel
import com.example.noveltoon.domain.repository.NovelRepository
import javax.inject.Inject

class CreateNovelUseCase @Inject constructor(
    private val repository: NovelRepository
) {

    suspend operator fun invoke(
        title: String,
        description: String?
    ): Novel {
        if (title.isBlank()) {
            throw AppException.Validation("Title không được rỗng")
        }

        return repository.createNovel(CreateNovelRequest(title, description))
    }
}