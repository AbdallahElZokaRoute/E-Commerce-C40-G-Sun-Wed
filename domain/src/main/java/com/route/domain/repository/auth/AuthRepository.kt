package com.route.domain.repository.auth

import com.route.domain.ApiResult
import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity?>>
    suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity?>>
}

interface AuthOnlineDataSource {
    suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity?>>
    suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity?>>
}


