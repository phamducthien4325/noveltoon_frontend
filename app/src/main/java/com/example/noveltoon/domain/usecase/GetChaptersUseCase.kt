package com.example.noveltoon.domain.usecase

import com.example.noveltoon.domain.repository.ChapterRepository
import javax.inject.Inject

class GetChaptersUseCase @Inject constructor(
    private val repository: ChapterRepository
) {
    operator fun invoke(novelId: String) =
        repository.getChapters(novelId)
}