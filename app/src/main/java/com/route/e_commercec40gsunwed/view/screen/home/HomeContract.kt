package com.route.e_commercec40gsunwed.view.screen.home

import androidx.compose.runtime.State
import com.route.domain.entities.categories.CategoryItemEntity

interface HomeContract {
    interface ViewModel {
        fun invokeActions(action: Action)
        val states: State<States>
        val events: State<Events>
    }

    sealed interface Action {
        data object ClickOnCart : Action
        data object ViewAllCategories : Action
        data class ClickOnCertainCategory(val categoryID: String) : Action
    }

    sealed interface States {
        data object Loading : States
        data class Error(val errorMessage: String?) : States
        data class Success(val categoriesList: List<CategoryItemEntity>) : States
        data object Idle : States
    }

    sealed interface Events {
        data class NavigateToSubCategory(val categoryClickedOnId: String) : Events
        data object NavigateToCart : Events
        data class NavigateToProductDetailsScreen(val productId: String) : Events
        data object Idle : Events
    }

}
