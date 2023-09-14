package com.example.watchflix.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.watchflix.composables.HomePage
import com.example.watchflix.composables.MoviesDetailScreen
import com.example.watchflix.composables.VideoScreen


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* setContentView(R.layout.activity_main2)*/
        setContent{
            WatchFlix()
        }
    }
}

@Composable
fun WatchFlix(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "MoviesHome"){
        composable("MoviesHome"){
            HomePage{
                val routewithQueryParams = "MoviesDetails?poster=${it.backdrop_path}&title=${it.title}&overview=${it.overview}"
                navController.navigate(routewithQueryParams)
            }
        }
        composable("MoviesDetails?poster={poster}&title={title}&overview={overview}",
        arguments = listOf(
            navArgument("poster"){
                type = NavType.StringType
            },
            navArgument("title"){
                type = NavType.StringType
            },
            navArgument("overview"){
                type = NavType.StringType
            }
        )
        ){
            val poster = it.arguments?.getString("poster")
            val title = it.arguments?.getString("title")
            val overview = it.arguments?.getString("overview")


            MoviesDetailScreen(navController,poster,title,overview)
        }
        composable("MovieVideo"){
            VideoScreen()
        }
    }

}


