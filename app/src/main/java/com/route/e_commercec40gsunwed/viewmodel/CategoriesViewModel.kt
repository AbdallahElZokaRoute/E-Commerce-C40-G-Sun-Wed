package com.route.e_commercec40gsunwed.viewmodel

import androidx.lifecycle.ViewModel
import com.route.e_commercec40gsunwed.R

class CategoriesViewModel: ViewModel() {

    val categoryItem = listOf(
        Pair(R.drawable.women_category, "Women's \n fashion"),
        Pair(R.drawable.beauty, "Beauty"),
        Pair(R.drawable.men_category, " Men's\nfashion"),
        Pair(R.drawable.headphone, "Headphone"),
        Pair(R.drawable.electronic, "Laptops & \n Electronic"),
        Pair(R.drawable.skincare, "Skincare"),
        Pair(R.drawable.baby, "Baby \n Toy"),
        Pair(R.drawable.camera, "Camera"),

        )
}