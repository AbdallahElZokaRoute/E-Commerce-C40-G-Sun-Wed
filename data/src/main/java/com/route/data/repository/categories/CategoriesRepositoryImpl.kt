package com.route.data.repository.categories

import com.route.domain.ApiResult
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.repository.categories.CategoriesOnlineDataSource
import com.route.domain.repository.categories.CategoriesRepository
import kotlinx.coroutines.flow.Flow

class CategoriesRepositoryImpl(
    private val onlineDataSource: CategoriesOnlineDataSource
) : CategoriesRepository {
    override suspend fun getCategories(): Flow<ApiResult<List<CategoryItemEntity>>> {
        return onlineDataSource.fetchCategories()
    }
}
