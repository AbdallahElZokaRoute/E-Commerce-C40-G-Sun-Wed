package com.route.data.mappers

import com.route.data.models.auth.AuthResponseModel
import com.route.data.models.auth.UserModel
import com.route.data.request.LoginRequestModel
import com.route.data.request.RegisterRequestModel
import com.route.domain.entities.AuthResponseEntity
import com.route.domain.entities.UserEntity
import com.route.domain.entities.request.LoginRequestEntity
import com.route.domain.entities.request.RegisterRequestEntity


fun AuthResponseModel.toEntity(): AuthResponseEntity {
    return AuthResponseEntity(message, userEntity = userModel?.toEntity(), statusMessage, token)
}

fun UserModel.toEntity(): UserEntity {
    return UserEntity(role, name, email)
}

fun LoginRequestEntity.toModel(): LoginRequestModel {
    return LoginRequestModel(password, email)
}

fun RegisterRequestEntity.toModel(): RegisterRequestModel {
    return RegisterRequestModel(password, phone, rePassword, name, email)
}
