package com.example.watchflix.composables



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.watchflix.R
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.viewmodel.CustomViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun HomePage(onClick:(resource : ResultX)->Unit) {

    val viewModel = getViewModel<CustomViewModel>()
    val result = viewModel.popularlist.collectAsState().value
    val result1 = viewModel.toplist.collectAsState().value
    val result2 = viewModel.uplist.collectAsState().value


    Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(221.dp),
                    elevation = CardDefaults.cardElevation(),

                    ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        val imageDrawable = painterResource(id = R.drawable.wallpaper)

                        Image(
                            painter = imageDrawable,
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(221.dp)
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Blade Runner 2049",
                                color = Color.White,
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 8.dp)
                            )

                            Text(
                                text = "Thirty years after the events of the first film, a new blade runner, LAPD officer K (Ryan Gosling), unearths a long-buried secret that has the potential to plunge what's left of society into chaos. K's discovery leads him on a quest to find Rick Deckard (Harrison Ford), a former LAPD blade runner who has been missing for 30 years.",
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    item {
                        // Popular Movies
                        Text(
                            text = "Popular Movies",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }

                    item {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                        ) {
                            val resource = result?.body()
                            if (resource != null) {
                                items(resource.results) {
                                    PopularItem(it,onClick)
                                }

                            }
                        }

                    }

                    item {
                        // Top Rated Movies

                        Text(
                            text = "Top Rated Movies",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }

                    item {
                        // RecyclerView for Top Rated Movies
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                        ){
                            val resource = result1?.body()
                            if (resource != null) {
                                items(resource.results) {
                                    TopRatedItem(it)
                                }

                            }
                        }


                    }

                    item {
                        // Upcoming Movies
                        Text(
                            text = "Upcoming Movies",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }



                    item {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                        ) {
                            val resource = result2?.body()
                            if (resource != null) {
                                items(resource.results) {
                                    UpcomingItem(it)
                                }

                            }
                        }
                    }
                }
            }
        }














