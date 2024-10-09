package com.route.e_commercec40gsunwed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.route.e_commercec40gsunwed.components.ProductsGrid
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.route.e_commercec40gsunwed.view.composable.MyBottomAppBar
import com.route.e_commercec40gsunwed.view.screen.AccountRoute
import com.route.e_commercec40gsunwed.view.screen.AccountScreen
import com.route.e_commercec40gsunwed.view.screen.CategoriesRoute
import com.route.e_commercec40gsunwed.view.screen.HomeRoute
import com.route.e_commercec40gsunwed.view.screen.HomeScreen
import com.route.e_commercec40gsunwed.view.screen.WishListRoute
import com.route.e_commercec40gsunwed.view.screen.WishListScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.e_commercec40gsunwed.components.ProductGridRoute
import com.route.e_commercec40gsunwed.screens.CategoriesScreen
import com.route.e_commercec40gsunwed.screens.CategoriesViewModel
import androidx.compose.ui.tooling.preview.Preview
import com.route.e_commercec40gsunwed.categories.CategoriesScreen
import com.route.e_commercec40gsunwed.ui.theme.ECommerceC40GSunWedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ECommerceC40GSunWedTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    MyBottomAppBar(navController = navController)

                }) { paddingValues ->
                    AppNavigation(
                        navController = navController, modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    )
                }
            }

        }
    }

    @Composable
    fun AppNavigation(
        modifier: Modifier,
        navController: NavHostController,
    ) {

        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = modifier
        ) {
            composable<HomeRoute> {
                HomeScreen()
            }

            composable<CategoriesRoute> {
                val viewModel: CategoriesViewModel = viewModel()
                CategoriesScreen(
                    categoriesViewModel = viewModel,
                    modifier = Modifier
                )
            }

            composable<WishListRoute> {
                WishListScreen()
            }

            composable<AccountRoute> {
                AccountScreen()
            }
            composable<ProductGridRoute> {
                ProductsGrid()
            }
            composable<CategoriesRoute> {
                CategoriesScreen()
            }
        }
    }
}
