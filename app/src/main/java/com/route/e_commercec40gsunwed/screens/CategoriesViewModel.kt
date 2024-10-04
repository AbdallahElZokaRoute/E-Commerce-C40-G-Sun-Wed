package com.route.e_commercec40gsunwed.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(

) : ViewModel() {
    var categories = com.route.e_commercec40gsunwed.model.CategoriesList
}
