package com.route.data.dataSource.auth

import com.route.data.executeAPI
import com.route.data.mappers.toEntity
import com.route.data.mappers.toModel
import com.route.data.online.api.AuthService
import com.route.data.utils.handleError
import com.route.domain.ApiResult
import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity
import com.route.domain.repository.auth.AuthOnlineDataSource
import kotlinx.coroutines.flow.Flow

class AuthOnlineDataSourceImpl(
    private val authService: AuthService
) : AuthOnlineDataSource {
    override suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity?>> {
        return executeAPI { authService.login(requestEntity.toModel()).body()?.toEntity() }
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity?>> {
        return executeAPI { authService.register(requestEntity.toModel()).body()?.toEntity() }
    }
}
