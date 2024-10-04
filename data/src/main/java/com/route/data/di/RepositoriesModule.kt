package com.route.data.di

import com.route.data.dataSource.AuthOnlineDataSourceImpl
import com.route.data.online.api.AuthService
import com.route.data.repository.AuthRepositoryImpl
import com.route.domain.repository.AuthOnlineDataSource
import com.route.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    @Singleton
    fun provideAuthRepository(onlineDataSource: AuthOnlineDataSource): AuthRepository {
        return AuthRepositoryImpl(onlineDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthDataSource(authService: AuthService): AuthOnlineDataSource {
        return AuthOnlineDataSourceImpl(authService = authService)
    }
}
