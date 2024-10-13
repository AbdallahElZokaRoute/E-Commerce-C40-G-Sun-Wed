package com.route.domain.useCases.categories

import com.route.domain.ApiResult
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.repository.categories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository,
) {
    suspend operator fun invoke(): Flow<ApiResult<List<CategoryItemEntity>>> {
        return repository.getCategories()
    }
}
