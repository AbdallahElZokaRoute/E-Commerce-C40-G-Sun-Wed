package com.route.data.repository.categories

import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.repository.categories.CategoriesOnlineDataSource
import com.route.domain.repository.categories.CategoriesRepository

class CategoriesRepositoryImpl(
    private val onlineDataSource: CategoriesOnlineDataSource
) : CategoriesRepository {
    override suspend fun getCategories(): List<CategoryItemEntity> {
        return onlineDataSource.fetchCategories()
    }
}
