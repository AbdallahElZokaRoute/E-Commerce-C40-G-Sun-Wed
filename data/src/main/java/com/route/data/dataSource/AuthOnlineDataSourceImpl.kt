package com.route.data.dataSource

import com.route.data.mappers.toEntity
import com.route.data.mappers.toModel
import com.route.data.online.api.AuthService
import com.route.data.utils.handleError
import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity
import com.route.domain.repository.AuthOnlineDataSource

class AuthOnlineDataSourceImpl(
    private val authService: AuthService
) : AuthOnlineDataSource {
    override suspend fun login(requestEntity: LoginRequestEntity): AuthResponseEntity {
        try {
            val response = authService.login(requestEntity.toModel())
            if (response.code() in 200..300) {
                return response.body()?.toEntity()!!
            }
            throw handleError(response)

        } catch (e: Exception) {
            throw handleError(e)
        }
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): AuthResponseEntity {
        try {
            val response = authService.register(requestEntity.toModel())
            if (response.code() in 200..300) {
                return response.body()?.toEntity()!!
            }
            throw handleError(response)
        } catch (e: Exception) {
            throw handleError(e)
        }
    }


}
