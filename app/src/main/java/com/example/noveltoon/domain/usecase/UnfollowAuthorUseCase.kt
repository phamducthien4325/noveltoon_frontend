package com.example.noveltoon.domain.usecase

import com.example.noveltoon.domain.repository.UserRepository
import javax.inject.Inject

class UnfollowAuthorUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(authorId: String) =
        repository.unfollowAuthor(authorId)
}
