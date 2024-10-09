package com.route.e_commercec40gsunwed.view.screen.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.useCases.categories.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel() {
    val categoriesState = mutableStateListOf<CategoryItemEntity>()
    val errorState = mutableStateOf("")
    fun getCategories() {
        viewModelScope.launch {
            try {
                val response = getCategoriesUseCase()
                if (categoriesState.isNotEmpty())
                    categoriesState.clear()
                categoriesState.addAll(response)
            } catch (e: Exception) {
                errorState.value = "${e.message}"
            }
        }

    }

}