package com.route.e_commercec40gsunwed.view.composable

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.ui.theme.Blue
import com.route.e_commercec40gsunwed.viewmodel.CategoriesViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Categories(modifier: Modifier = Modifier, vm: CategoriesViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = Unit) {
        vm.getCategories()
    }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.categories),
                fontSize = 20.sp,
                color = Blue,
                modifier = Modifier.padding(10.dp)
            )

            TextButton(
                onClick = {
                    // Handle the click action here
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.view_all),
                    fontSize = 16.sp,
                    color = Blue
                )
            }


        }

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(vm.categoriesState) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    GlideImage(
                        model = item.image,
                        contentDescription = "Category Image",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(95.dp), // Adjust the size as needed
                        contentScale = ContentScale.Crop,
                    )
                    // Flows ()
                    Text(
                        text = item.name ?: "",
                        fontSize = 16.sp,
                        color = Blue,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CategoriesPreview() {
    Categories()
}