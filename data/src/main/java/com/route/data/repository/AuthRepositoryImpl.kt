package com.route.data.repository

import com.route.domain.ApiResult
import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity
import com.route.domain.repository.auth.AuthOnlineDataSource
import com.route.domain.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val onlineDataSource: AuthOnlineDataSource
) : AuthRepository {
    override suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity?>> {
        return onlineDataSource.login(requestEntity)
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity?>> {
        return onlineDataSource.register(requestEntity)
    }

}
