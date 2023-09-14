package com.example.watchflix.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.watchflix.network.Data.Result


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopRatedItem(resource: Result) {
    if (resource != null) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(140.dp)
        ) {
            GlideImage(
                model = "https://image.tmdb.org/t/p/w220_and_h330_face" + resource.backdrop_path,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}