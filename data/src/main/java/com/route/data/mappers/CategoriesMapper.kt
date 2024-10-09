package com.route.data.mappers

import com.route.data.models.categories.CategoriesResponseModel
import com.route.data.models.categories.CategoryDataModel
import com.route.data.models.categories.Metadata
import com.route.domain.entities.categories.CategoriesResponse
import com.route.domain.entities.categories.CategoryItemEntity

fun CategoriesResponseModel.toEntity(): CategoriesResponse {
    return CategoriesResponse(metadata?.toEntity(), data?.map {
        it.toEntity()
    }, results = results)
}

fun CategoryDataModel.toEntity(): CategoryItemEntity {
    return CategoryItemEntity(image, createdAt, name, id, slug, updatedAt)
}

fun Metadata.toEntity(): com.route.domain.entities.categories.Metadata {
    return com.route.domain.entities.categories.Metadata(
        numberOfPages, limit, currentPage
    )
}