package com.route.e_commercec40gsunwed

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.route.e_commercec40gsunwed.ui.theme.Blue
import com.route.e_commercec40gsunwed.ui.theme.ECommerceC40GSunWedTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceC40GSunWedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SplashActivityContent(modifier = Modifier.padding(innerPadding))
                    LaunchedEffect(key1 = Unit) {
                        Handler(Looper.getMainLooper()).postDelayed({
                            navigateToMainScreen()
                        }, 2000)
                    }
                }
            }
        }
    }

    private fun navigateToMainScreen() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

@Composable
fun SplashActivityContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Blue)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.upper_light),
            contentDescription = stringResource(R.string.upper_light_content_description),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(R.drawable.route_logo),
            contentDescription = stringResource(R.string.route_logo_content_description)
        )
        Image(
            painter = painterResource(R.drawable.lower_light),
            contentDescription = stringResource(R.string.lower_light_content_description),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashActivityContentPreview() {
    SplashActivityContent()
}