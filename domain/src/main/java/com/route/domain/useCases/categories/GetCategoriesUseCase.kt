package com.route.domain.useCases.categories

import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.repository.categories.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository,
) {
    suspend operator fun invoke(): List<CategoryItemEntity> {
        return repository.getCategories()
    }
}
