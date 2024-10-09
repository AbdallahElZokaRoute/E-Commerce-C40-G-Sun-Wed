package com.route.domain.useCases.auth

import com.route.domain.repository.auth.TokenRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(private val repository: TokenRepository) {
    suspend operator fun invoke(): String {
        return repository.getToken()
    }
}
