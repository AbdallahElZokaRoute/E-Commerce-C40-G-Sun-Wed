package com.route.domain.useCases

import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(loginRequestEntity: LoginRequestEntity): AuthResponseEntity {
        return repository.login(loginRequestEntity)
    }
}
