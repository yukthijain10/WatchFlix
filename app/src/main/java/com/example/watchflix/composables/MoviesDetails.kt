package com.example.watchflix.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.watchflix.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MoviesDetailScreen(
    navController: NavHostController,
    poster: String?,
    title: String?,
    overview: String?,

) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        item {
            // CardView with ImageView
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(221.dp),
                elevation = CardDefaults.cardElevation()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    GlideImage(
                        model = "https://image.tmdb.org/t/p/w220_and_h330_face"+poster,
                        contentDescription ="" ,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop

                    )


                }
            }
        }

        item {
            // Movie Details Text
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            // Handle the button click to play the video
                        },
                        modifier = Modifier
                            .height(40.dp) // Adjust the height for a rectangular button
                            .fillMaxWidth() // Fill the available width
                             // Make the button color red
                    ) {
                        Text(text = "Play", color = Color.White)
                    }
                }
                if (title != null) {
                    Text(
                        text = title,
                        color = Color.White,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                if (overview != null) {
                    Text(
                        text = overview,
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )
                }
            }
        }
    }
}

