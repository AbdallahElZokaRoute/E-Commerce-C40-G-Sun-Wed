package com.route.data.models.categories

import com.google.gson.annotations.SerializedName

data class CategoriesResponseModel(

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<CategoryDataModel>? = null,

	@field:SerializedName("results")
	val results: Int? = null
)

data class CategoryDataModel(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class Metadata(

	@field:SerializedName("numberOfPages")
	val numberOfPages: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null
)
