package com.route.domain.repository.auth

import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity

interface AuthRepository {
    suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity
    suspend fun register(requestEntity: RegisterRequestEntity): AuthResponseEntity
}

interface AuthOnlineDataSource {
    suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity
    suspend fun register(requestEntity: RegisterRequestEntity): AuthResponseEntity
}


