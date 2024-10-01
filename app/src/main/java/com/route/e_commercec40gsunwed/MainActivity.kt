package com.route.e_commercec40gsunwed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.route.e_commercec40gsunwed.screens.CategoriesScreen
import com.route.e_commercec40gsunwed.screens.CategoriesViewModel
import com.route.e_commercec40gsunwed.ui.theme.ECommerceC40GSunWedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                   CategoriesScreen(CategoriesViewModel(), Modifier)
        }
    }
}
