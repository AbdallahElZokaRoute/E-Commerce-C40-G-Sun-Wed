package com.route.data.utils

import android.util.Log
import com.google.gson.Gson
import com.route.data.R
import com.route.data.models.auth.AuthResponseModel
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

fun handleError(throwable: Throwable): Exception {
    return when (throwable) {
        // https://wwww.newsapi.org
        is UnknownHostException, is IOException -> {
            Log.e("TAG", "handleError: ${throwable.message}")
            R.string.check_your_internet_connection
            Exception(throwable)
        }

        else -> {
            Log.e("TAG", "handleError: ${throwable.message}")
            Log.e("TAG", "handleError: Throwable object : $throwable")
            Exception(throwable)
        }
    }
}

fun <T> handleError(response: Response<T>): Exception {
    val sourceResponse = response.errorBody()?.string()?.fromJson(AuthResponseModel::class.java)
    Log.e("TAG", "handleError:  message => ${sourceResponse?.message}")
    return Exception(sourceResponse?.message)
}

fun <T> String.fromJson(clazz: Class<T>): T {
    val gson = Gson()
    return gson.fromJson(this, clazz)
}
