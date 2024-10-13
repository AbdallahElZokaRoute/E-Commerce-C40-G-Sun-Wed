package com.route.e_commercec40gsunwed.view.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.ApiResult
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.domain.useCases.categories.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel(), HomeContract.ViewModel {
    private val _states = mutableStateOf<HomeContract.States>(HomeContract.States.Idle)
    private val _events = mutableStateOf<HomeContract.Events>(HomeContract.Events.Idle)

    override fun invokeActions(action: HomeContract.Action) {
        when (action) {
            HomeContract.Action.ClickOnCart -> {
                // Navigate To Cart Screen
            }

            is HomeContract.Action.ClickOnCertainCategory -> {
                // Navigate To Certain Category
            }

            HomeContract.Action.ViewAllCategories -> {
                // Navigate To Categories (Screen or Tab)

            }
        }
    }

    override val states: State<HomeContract.States>
        get() = _states
    override val events: State<HomeContract.Events>
        get() = _events


    fun getCategories() {
        viewModelScope.launch {
            getCategoriesUseCase()
                .collect { response ->
                    when (response) {
                        is ApiResult.Error -> {
                            _states.value = HomeContract.States.Error(response.errorMessage)
                        }

                        is ApiResult.Loading -> {
                            _states.value = HomeContract.States.Loading
                        }

                        is ApiResult.Success -> {
                            _states.value = HomeContract.States.Success(response.data)
                        }
                    }

                }
        }
    }
}