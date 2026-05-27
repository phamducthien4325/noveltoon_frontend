package com.example.noveltoon.domain.usecase

import com.example.noveltoon.core.exception.AppException
import com.example.noveltoon.data.remote.dto.UpdateDraftRequest
import com.example.noveltoon.domain.model.Chapter
import com.example.noveltoon.domain.repository.ChapterRepository
import javax.inject.Inject

class UpdateDaftUseCase @Inject constructor(
    private val repository: ChapterRepository
) {
    suspend operator fun invoke(
        chapterId: String,
        title: String,
        content: String,
    ): Chapter {
        if (chapterId.isBlank()) {
            throw AppException.Validation("chapterId không được rỗng")
        }

        return repository.updateDraft(chapterId, UpdateDraftRequest(title, content))
    }
}