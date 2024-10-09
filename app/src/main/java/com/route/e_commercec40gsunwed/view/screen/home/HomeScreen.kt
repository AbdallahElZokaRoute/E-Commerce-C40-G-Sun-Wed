package com.route.e_commercec40gsunwed.view.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.view.composable.Categories
import com.route.e_commercec40gsunwed.view.composable.HomeAppliance
import com.route.e_commercec40gsunwed.view.composable.ImageSlider
import com.route.e_commercec40gsunwed.view.composable.SearchBar
import com.route.e_commercec40gsunwed.viewmodel.SearchViewModel
import kotlinx.serialization.Serializable


@Serializable
object HomeRoute

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.getCategories()
    }
    val navHostController = rememberNavController()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        // Image item (route logo)
        item {
            Image(
                painter = painterResource(id = R.drawable.route_logo_2),
                contentDescription = "route logo image",
                modifier = Modifier
                    .size(65.dp),
                contentScale = ContentScale.Fit
            )
        }

        // SearchBar item
        item {
            SearchBar()
        }

        // ImageSlider item
        item {
            ImageSlider()
        }

        // Categories item
        item {
            Categories()
        }

        // HomeAppliance item
        item {
            HomeAppliance()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenView() {
    HomeScreen()
}