package com.example.noveltoon.domain.usecase

import com.example.noveltoon.domain.repository.NovelRepository
import javax.inject.Inject

class GetNovelsUseCase @Inject constructor(
    private val repository: NovelRepository
) {
    suspend operator fun invoke() =
        repository.getNovels()
}