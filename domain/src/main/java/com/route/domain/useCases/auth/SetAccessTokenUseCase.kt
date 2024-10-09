package com.route.domain.useCases.auth

import com.route.domain.repository.auth.TokenRepository
import javax.inject.Inject

class SetAccessTokenUseCase @Inject constructor(private val repository: TokenRepository) {
    suspend operator fun invoke(value: String) {
        repository.setToken(value)
    }
}
