package com.route.data.repository

import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity
import com.route.domain.repository.AuthOnlineDataSource
import com.route.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val onlineDataSource: AuthOnlineDataSource
) : AuthRepository {
    override suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity {
        return onlineDataSource.login(requestEntity)
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): AuthResponseEntity {
        return onlineDataSource.register(requestEntity)
    }

}
