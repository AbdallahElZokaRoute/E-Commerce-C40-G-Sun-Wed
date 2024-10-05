package com.route.e_commercec40gsunwed.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.model.CategoriesPartition
import com.route.e_commercec40gsunwed.model.Category
import com.route.e_commercec40gsunwed.ui.theme.DarkBlue
import com.route.e_commercec40gsunwed.ui.theme.LightBlue


@Composable
fun CategoriesScreen(){
    Row () {
        CategoriesList(Modifier)
        Column(Modifier) {
            CategoriesText("Women's Fashion",Modifier.padding(10.dp))
            ImageAd(R.drawable.img_1,modifier = Modifier.fillMaxWidth())
            ItemsList(CategoriesViewModel())
        }
    }


}
@Composable
fun CategoriesList(modifier: Modifier){
    Box (modifier.fillMaxHeight()
        .aspectRatio(0.2f)
        .padding(10.dp)
        .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp))
        .background(LightBlue)){
        LazyColumn {
            items(CategoriesPartition.size){index ->
                CategoriesText(CategoriesPartition[index], Modifier.padding(horizontal = 10.dp, vertical = 30.dp))
            }
        }
    }
}


@Composable
fun CategoriesText(text: String, modifier:Modifier){
    Text(text,modifier, fontSize = 14.sp,fontWeight = FontWeight.Bold, color = DarkBlue)
}

@Composable
fun ItemsList(categoriesViewModel: CategoriesViewModel){
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(categoriesViewModel.categoriesList.size){ index ->
            Item(categoriesViewModel.categoriesList[index])
        }
    }
}

@Composable
fun ImageAd(image: Int, modifier: Modifier) {
    Image(painter = painterResource(image),"", modifier = modifier, contentScale = ContentScale.Crop)

}
@Composable
fun Item(category: Category){
    Column(modifier = Modifier.padding(10.dp)) {
    Image(painter = painterResource(category.Image),"",
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
        .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomStart = 5.dp, bottomEnd = 5.dp))
            .height(70.dp)
            .width(70.dp)
    )
    Text(text = category.text, fontSize = 12.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
}
    }

@Preview(showBackground = true)
@Composable
fun CategoriesListPreview(){
    CategoriesList(Modifier)
}

@Preview(showBackground = true)
@Composable
fun ItemsListPreview(){
    ItemsList(CategoriesViewModel())
}
@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview(){
    CategoriesScreen()
    
}