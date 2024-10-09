package com.route.data.repository

import com.route.domain.repository.auth.TokenOfflineDataSource
import com.route.domain.repository.auth.TokenRepository

class TokenRepositoryImpl(private val offlineDataSource: TokenOfflineDataSource) : TokenRepository {
    override suspend fun getToken(): String {
        return offlineDataSource.getToken()
    }

    override suspend fun setToken(value: String) {
        offlineDataSource.setToken(value)
    }

}
