package com.route.e_commercec40gsunwed.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.useCases.auth.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
) : ViewModel() {
    val navigationState = mutableStateOf<SplashDestination>(SplashDestination.Idle)
    fun checkAccessToken() {
        viewModelScope.launch {
            val token = getAccessTokenUseCase()
            if (token.isEmpty()) {
                // Navigate to Auth or register or login
                navigationState.value = SplashDestination.Login
            } else {
                // Navigate To Home
                navigationState.value = SplashDestination.Home

            }
        }
    }

}
