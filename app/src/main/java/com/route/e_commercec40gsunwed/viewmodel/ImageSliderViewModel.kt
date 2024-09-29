package com.route.e_commercec40gsunwed.viewmodel

import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import com.google.accompanist.pager.rememberPagerState
import com.route.e_commercec40gsunwed.R

class ImageSliderViewModel:ViewModel() {

    val imageSlider = listOf(
        R.drawable.offer25,
        R.drawable.offer30,
        R.drawable.offer20
    )

}