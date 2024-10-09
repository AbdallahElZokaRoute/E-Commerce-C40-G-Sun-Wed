package com.route.data.dataSource.categories

import android.util.Log
import com.route.data.mappers.toEntity
import com.route.data.online.api.CategoriesService
import com.route.data.utils.handleError
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.repository.categories.CategoriesOnlineDataSource

class CategoriesOnlineDataSourceImpl(
    private val webService: CategoriesService
) : CategoriesOnlineDataSource {
    override suspend fun fetchCategories(): List<CategoryItemEntity> {
        return try {
            webService.fetchCategories().data?.map {
                it.toEntity()
            } ?: listOf()
        } catch (e: Exception) {
            Log.e("TAG", "fetchCategories: $e")
            throw handleError(e)
        }
    }
}
