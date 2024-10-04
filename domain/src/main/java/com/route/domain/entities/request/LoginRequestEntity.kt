package com.route.domain.entities.request


data class LoginRequestEntity(
    val password: String? = null,
    val email: String? = null
)
