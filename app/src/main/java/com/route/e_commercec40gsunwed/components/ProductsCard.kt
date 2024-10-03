package com.route.e_commercec40gsunwed.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.route.e_commercec40gsunwed.R
import com.route.e_commercec40gsunwed.ui.theme.FadedBlue
import com.route.e_commercec40gsunwed.ui.theme.Heather
import com.route.e_commercec40gsunwed.ui.theme.NightBlue

@Composable
fun ProductsCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .border(2.dp, Heather, shape = RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    ) {
        ConstraintLayout(modifier = Modifier.size(width = 191.dp, height = 237.dp)) {
            val (image, title, description, price, discount, reviews, reviewsNum, starIcon, favoriteButton, addButton) = createRefs()

            Image(
                painter = painterResource(R.drawable.air_jordan),
                contentDescription = "Shoe Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { /* Handle favorite action */ },
                modifier = Modifier
                    .size(42.dp)
                    .constrainAs(favoriteButton) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_favorite),
                    contentDescription = "Favorite Button",
                    tint = Color.Unspecified
                )
            }

            Text(
                text = "Nike Air Jordan",
                color = NightBlue,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    .constrainAs(title) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                    })

            Text(
                text = "Nike shoes flexible for wo...",
                color = NightBlue,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp)
                    .constrainAs(description) {
                        top.linkTo(title.bottom)
                        start.linkTo(title.start)
                    }
            )

            Text(
                text = "EGP 1,100",
                color = NightBlue,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 8.dp, top = 10.dp)
                    .constrainAs(price) {
                        top.linkTo(description.bottom)
                        start.linkTo(description.start)
                    })
            Text(
                text = "1300 EGP",
                textDecoration = TextDecoration.LineThrough,
                color = FadedBlue,
                fontSize = 11.sp,
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp, top = 10.dp)
                    .constrainAs(discount) {
                        top.linkTo(price.top)
                        bottom.linkTo(price.bottom)
                        start.linkTo(price.end)
                    })

            Text(
                text = "Review",
                color = NightBlue,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 8.dp, top = 12.dp)
                    .constrainAs(reviews) {
                        top.linkTo(price.bottom)
                        start.linkTo(price.start)
                    })
            Text(
                text = "(4.3)",
                color = NightBlue,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 4.dp, top = 12.dp)
                    .constrainAs(reviewsNum) {
                        top.linkTo(reviews.top)
                        bottom.linkTo(reviews.bottom)
                        start.linkTo(reviews.end)
                    })
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = "Star Icon",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 4.dp, top = 12.dp)
                    .size(15.dp)
                    .constrainAs(starIcon) {
                        top.linkTo(reviewsNum.top)
                        bottom.linkTo(reviewsNum.bottom)
                        start.linkTo(reviewsNum.end)
                    }
            )

            IconButton(
                onClick = { /* Handle favorite action */ },
                modifier = Modifier
                    .size(42.dp)
                    .padding(top = 12.dp, end = 4.dp)
                    .constrainAs(addButton) {
                        top.linkTo(starIcon.top)
                        bottom.linkTo(starIcon.bottom)
                        end.linkTo(parent.end)
                    }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = "Add Button",
                    tint = Color.Unspecified
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductsCardPreview() {
    ProductsCard()
}