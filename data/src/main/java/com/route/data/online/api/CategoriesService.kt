package com.route.data.online.api

import com.route.data.models.categories.CategoriesResponseModel
import retrofit2.http.GET

interface CategoriesService {
    @GET("categories")
    suspend fun fetchCategories(): CategoriesResponseModel
}
