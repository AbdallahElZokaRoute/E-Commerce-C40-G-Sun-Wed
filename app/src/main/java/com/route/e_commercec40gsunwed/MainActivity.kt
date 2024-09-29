package com.route.e_commercec40gsunwed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.route.e_commercec40gsunwed.view.screen.AccountRoute
import com.route.e_commercec40gsunwed.view.screen.AccountScreen
import com.route.e_commercec40gsunwed.view.screen.CategoriesRoute
import com.route.e_commercec40gsunwed.view.screen.CategoriesScreen
import com.route.e_commercec40gsunwed.view.screen.HomeRoute
import com.route.e_commercec40gsunwed.view.screen.HomeScreen
import com.route.e_commercec40gsunwed.view.screen.WishListRoute
import com.route.e_commercec40gsunwed.view.screen.WishListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()


            AppNavigation(navController = navController, modifier = Modifier.fillMaxSize())
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
            CategoriesScreen()
        }

        composable<WishListRoute> {
            WishListScreen()
        }

        composable<AccountRoute> {
            AccountScreen()
        }
    }
}
