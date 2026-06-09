package com.example.noveltoon.domain.usecase

import com.example.noveltoon.domain.repository.UserRepository
import javax.inject.Inject

class FollowAuthorUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(authorId: String) =
        repository.followAuthor(authorId)
}
