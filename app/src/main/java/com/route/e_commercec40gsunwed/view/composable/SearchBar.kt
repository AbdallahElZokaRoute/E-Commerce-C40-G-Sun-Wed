package com.route.e_commercec40gsunwed.view.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.ui.theme.Blue
import com.route.e_commercec40gsunwed.viewmodel.SearchViewModel

@Composable
fun SearchBar(modifier: Modifier = Modifier, vm: SearchViewModel= viewModel()) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        TextField(
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 10.dp)
                .clip(RoundedCornerShape(30.dp))
                .border(
                    border = BorderStroke(color = Blue, width = 1.dp),
                    shape = RoundedCornerShape(30.dp)
                )
                ,
            value = vm.searchQuery,
            onValueChange = { vm.setSearchQuery(it) },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Blue,
                unfocusedTextColor = Blue,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Blue,
            ),
            placeholder = {
                Text(text = stringResource(R.string.what_do_you_want_to_search))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                //search view model
            }), leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = "Search icon",
                    modifier = Modifier.size(25.dp)
                )
            }
        )
        Image(
            painter = painterResource(id = R.drawable.icon_shopping_cart),
            contentDescription = "shopping cart icon",
            modifier = Modifier
                .padding(start = 10.dp)
                .size(25.dp)
                .clickable {

                },
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchBarPreview() {
    SearchBar(vm = SearchViewModel())
}