package com.route.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.route.data.dataSource.auth.AuthOnlineDataSourceImpl
import com.route.data.dataSource.categories.CategoriesOnlineDataSourceImpl
import com.route.data.dataStore.TokenOfflineDataSourceImpl
import com.route.data.online.api.AuthService
import com.route.data.online.api.CategoriesService
import com.route.data.repository.AuthRepositoryImpl
import com.route.data.repository.TokenRepositoryImpl
import com.route.data.repository.categories.CategoriesRepositoryImpl
import com.route.domain.repository.auth.AuthOnlineDataSource
import com.route.domain.repository.auth.AuthRepository
import com.route.domain.repository.auth.TokenOfflineDataSource
import com.route.domain.repository.auth.TokenRepository
import com.route.domain.repository.categories.CategoriesOnlineDataSource
import com.route.domain.repository.categories.CategoriesRepository
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

    @Provides
    @Singleton
    fun provideTokenOfflineDataSource(dataStore: DataStore<Preferences>): TokenOfflineDataSource {
        return TokenOfflineDataSourceImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(offlineDataSource: TokenOfflineDataSource): TokenRepository {
        return TokenRepositoryImpl(offlineDataSource = offlineDataSource)
    }

    @Provides
    @Singleton
    fun provideCategoriesOnlineDataSource(service: CategoriesService): CategoriesOnlineDataSource {
        return CategoriesOnlineDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideCategoriesRepository(onlineDataSource: CategoriesOnlineDataSource): CategoriesRepository {
        return CategoriesRepositoryImpl(onlineDataSource = onlineDataSource)
    }
}
