package com.route.e_commercec40gsunwed.view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.ui.theme.Blue
import com.route.e_commercec40gsunwed.view.screen.AccountRoute
import com.route.e_commercec40gsunwed.view.screen.CategoriesRoute
import com.route.e_commercec40gsunwed.view.screen.home.HomeRoute
import com.route.e_commercec40gsunwed.view.screen.WishListRoute

@Composable
fun MyBottomAppBar(navController: NavHostController) {
    var selectedIndex by remember { mutableStateOf(0) }


    BottomAppBar(
        modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
            containerColor = Blue,
        contentColor = Color.White
    ) {
        // Home Icon
        IconButton(
            onClick = {
                selectedIndex = 0
                navController.navigate(HomeRoute) // Navigate to home screen
            },
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = if (selectedIndex == 0){ R.drawable.home_bg_ic} else R.drawable.home_ic),
                contentDescription = "Home",
            )
        }

        // Categories Icon
        IconButton(
            onClick = {
                selectedIndex = 1
                navController.navigate(CategoriesRoute) // Navigate to categories screen
            },modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = if (selectedIndex == 1) R.drawable.categories_bg_ic else R.drawable.categories_ic),
                contentDescription = "Categories"
            )
        }

        // Love Icon
        IconButton(
            onClick = {
                selectedIndex = 2
                navController.navigate(WishListRoute) // Navigate to love screen
            },modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = if (selectedIndex == 2) R.drawable.heart_bg else R.drawable.heart),
                contentDescription = "Love"
            )
        }

        // Account Icon
        IconButton(
            onClick = {
                selectedIndex = 3
                navController.navigate(AccountRoute) // Navigate to account screen
            },modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = if (selectedIndex == 3) R.drawable.acc_bg_ic else R.drawable.acc_ic),
                contentDescription = "Account"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BottomAppBarPreview() {
    MyBottomAppBar(navController = rememberNavController())
}