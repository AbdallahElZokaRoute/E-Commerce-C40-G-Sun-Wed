package com.route.domain.repository.categories

import com.route.domain.ApiResult
import com.route.domain.entities.categories.CategoryItemEntity
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    suspend fun getCategories(): Flow<ApiResult<List<CategoryItemEntity>>>
}

interface CategoriesOnlineDataSource {
    suspend fun fetchCategories(): Flow<ApiResult<List<CategoryItemEntity>>>
}
