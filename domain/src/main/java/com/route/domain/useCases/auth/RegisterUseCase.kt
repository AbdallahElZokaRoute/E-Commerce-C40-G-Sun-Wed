package com.route.domain.useCases.auth

import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.RegisterRequestEntity
import com.route.domain.repository.auth.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(requestEntity: RegisterRequestEntity): AuthResponseEntity {
        return repository.register(requestEntity)
    }
}
