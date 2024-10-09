package com.route.data.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.route.domain.repository.auth.TokenOfflineDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class TokenOfflineDataSourceImpl(
    private val dataStore: DataStore<Preferences>,
) : TokenOfflineDataSource {
    private val TOKEN = stringPreferencesKey("token")

    override suspend fun getToken(): String = dataStore.data.map { preferences ->
        preferences[TOKEN] ?: ""
    }.first()

    override suspend fun setToken(value: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN] = value
        }
    }
}
