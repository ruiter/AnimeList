package com.ruiter.animelist.presentation.animelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruiter.animelist.R

@Preview(showBackground = true)
@Composable
fun AnimeCard() {

    Box(modifier = Modifier.fillMaxWidth().padding(16.dp) ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable { },
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp,

        ) {
            Spacer(modifier = Modifier.width(80.dp).height(90.dp))
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Anime title")
                Text(text = "Anime subtitle")
                Text(text = "Anime rating 7.1")
            }
        }

        Image(

            painter = painterResource(id = R.drawable.image_example),
            modifier = Modifier
                .size(width = 90.dp, height = 95.dp)
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentDescription = "anime image example",
            contentScale = ContentScale.FillBounds,

            )
    }
}