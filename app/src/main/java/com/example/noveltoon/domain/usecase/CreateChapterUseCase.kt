package com.example.noveltoon.domain.usecase

import com.example.noveltoon.core.exception.AppException
import com.example.noveltoon.data.remote.dto.CreateDraftRequest
import com.example.noveltoon.domain.model.Chapter
import com.example.noveltoon.domain.repository.ChapterRepository
import javax.inject.Inject

class CreateChapterUseCase @Inject constructor(
    private val repository: ChapterRepository
) {
    suspend operator fun invoke(
        novelId: String,
    ): Chapter {
        if (novelId.isBlank()) {
            throw AppException.Validation("novelId không được rỗng")
        }

//        val wordCount = content
//            .trim()
//            .split(Regex("\\s+")) // tách theo khoảng trắng
//            .filter { it.isNotBlank() }
//            .size
//
//        if (wordCount < 700) {
//            throw AppException.Validation("Content phải trên 700 từ")
//        }

        return repository.createChapter(CreateDraftRequest(novelId))
    }
}