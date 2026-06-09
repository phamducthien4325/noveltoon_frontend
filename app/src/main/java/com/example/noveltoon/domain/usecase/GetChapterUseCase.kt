package com.example.noveltoon.domain.usecase

import com.example.noveltoon.domain.repository.ChapterRepository
import javax.inject.Inject

class GetChapterUseCase @Inject constructor(
    private val repository: ChapterRepository
) {
    suspend operator fun invoke(chapterId: String) =
        repository.getChapter(chapterId)
}
