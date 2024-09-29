package com.route.e_commercec40gsunwed.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SearchViewModel:ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery :String get() = _searchQuery.value

    private val _isFocused = mutableStateOf(false)
    val isFocused :Boolean get() = _isFocused.value


    fun setSearchQuery(query:String){
        _searchQuery.value = query
    }
}