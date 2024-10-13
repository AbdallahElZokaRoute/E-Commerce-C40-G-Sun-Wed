package com.route.data.dataSource.categories

import android.util.Log
import com.route.data.executeAPI
import com.route.data.mappers.toEntity
import com.route.data.online.api.CategoriesService
import com.route.data.utils.handleError
import com.route.domain.ApiResult
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.repository.categories.CategoriesOnlineDataSource
import kotlinx.coroutines.flow.Flow

class CategoriesOnlineDataSourceImpl(
    private val webService: CategoriesService
) : CategoriesOnlineDataSource {
    override suspend fun fetchCategories(): Flow<ApiResult<List<CategoryItemEntity>>> {
        return executeAPI {
            webService.fetchCategories().data?.map {
                it.toEntity()
            } ?: listOf()
        }
    }
}
