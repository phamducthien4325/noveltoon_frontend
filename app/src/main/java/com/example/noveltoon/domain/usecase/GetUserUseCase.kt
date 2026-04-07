package com.example.noveltoon.domain.usecase

import com.example.noveltoon.data.local.entity.UserEntity
import com.example.noveltoon.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(): Flow<UserEntity?> {
        return repository.getUser()
    }

}