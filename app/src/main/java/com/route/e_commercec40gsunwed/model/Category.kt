package com.route.e_commercec40gsunwed.model

import com.route.e_commercec40gsunwed.R

data class Category(var image: Int,
                    var imageDescription: String)

var CategoriesList = listOf(
    Category(R.drawable.mens, "Men's Fashion"),
    Category(R.drawable.girl, "Camers"),
    Category(R.drawable.head, "Head Phones"),
    Category(R.drawable.kleidung, "Women's Fashion"),
    Category(R.drawable.makeup, "Makeup"),
    Category(R.drawable.skincare, "Skin care"),
    Category(R.drawable.skirt, "Skirt")
)
