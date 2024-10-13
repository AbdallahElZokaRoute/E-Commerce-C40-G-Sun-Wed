package com.route.domain.useCases.auth

import com.route.domain.ApiResult
import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(loginRequestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity?>> {
        return repository.login(loginRequestEntity)
    }
}
