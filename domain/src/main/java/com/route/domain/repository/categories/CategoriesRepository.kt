package com.route.domain.repository.categories

import com.route.domain.entities.categories.CategoryItemEntity

interface CategoriesRepository {
    suspend fun getCategories(): List<CategoryItemEntity>
}

interface CategoriesOnlineDataSource {
    suspend fun fetchCategories(): List<CategoryItemEntity>
}
