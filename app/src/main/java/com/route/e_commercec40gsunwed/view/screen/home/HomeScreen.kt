package com.route.e_commercec40gsunwed.view.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.route.domain.entities.categories.CategoryItemEntity
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.ui.theme.Blue
import com.route.e_commercec40gsunwed.view.composable.Categories
import com.route.e_commercec40gsunwed.view.composable.ErrorDialog
import com.route.e_commercec40gsunwed.view.composable.HomeAppliance
import com.route.e_commercec40gsunwed.view.composable.ImageSlider
import com.route.e_commercec40gsunwed.view.composable.SearchBar
import com.route.e_commercec40gsunwed.viewmodel.SearchViewModel
import kotlinx.serialization.Serializable


@Serializable
object HomeRoute

@Composable
fun HomeScreenRoute(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.getCategories()
    }
    RenderStates(state = viewModel.states.value)
}
// Finite State Machine


@Composable
fun RenderStates(
    state: HomeContract.States,
) {
    when (state) {
        is HomeContract.States.Error -> {
            val errorState = remember {
                mutableStateOf(state.errorMessage ?: "")
            }
            ErrorDialog(errorState = errorState)
        }

        HomeContract.States.Idle -> {}
        HomeContract.States.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Blue)
            }
        }

        is HomeContract.States.Success -> {
            HomeScreen(state.categoriesList)
        }
    }
}

@Composable
fun HomeScreen(
    categoriesList: List<CategoryItemEntity>,
) {
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
            Categories(categoriesList)
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
    HomeScreen(listOf())
}