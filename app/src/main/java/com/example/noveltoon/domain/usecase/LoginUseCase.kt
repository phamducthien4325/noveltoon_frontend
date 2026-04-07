package com.example.noveltoon.domain.usecase

import com.example.noveltoon.data.remote.dto.LoginRequest
import com.example.noveltoon.data.remote.responseDTO.ApiResult
import com.example.noveltoon.domain.model.AuthToken
import com.example.noveltoon.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ) : ApiResult<AuthToken> {
        if (email.isBlank()) {
            return ApiResult.Error("Email không được rỗng")
        }

        if (password.isBlank()) {
            return ApiResult.Error("Password không được rỗng")
        }

        return repository.login(LoginRequest(email, password))
    }
}