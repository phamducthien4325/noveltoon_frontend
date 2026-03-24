package com.example.noveltoon.domain.usecase

import com.example.noveltoon.domain.repository.HashtagRepository
import javax.inject.Inject

class GetHashtagsUseCase @Inject constructor(
    private val repository: HashtagRepository
) {

    suspend operator fun invoke() =
        repository.getHashtags()
}