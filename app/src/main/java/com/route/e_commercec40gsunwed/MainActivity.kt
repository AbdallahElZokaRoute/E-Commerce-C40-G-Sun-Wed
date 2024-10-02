package com.route.e_commercec40gsunwed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.route.e_commercec40gsunwed.components.ProductsGrid
import com.route.e_commercec40gsunwed.ui.theme.ECommerceC40GSunWedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceC40GSunWedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductsGrid(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
