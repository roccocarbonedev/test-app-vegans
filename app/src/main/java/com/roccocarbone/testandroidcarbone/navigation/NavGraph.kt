package com.roccocarbone.testandroidcarbone.navigation

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.roccocarbone.testandroidcarbone.data.models.Media
import com.roccocarbone.testandroidcarbone.ui.screens.DetailPage
import com.roccocarbone.testandroidcarbone.ui.screens.MasterPage

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "master") {
        composable("master") {
            MasterPage(onMediaSelected = { media ->

                Log.d("Tag", media.mediaTitleCustom)

                val mediaJson = Uri.encode(Gson().toJson(media))
                navController.navigate("detail/$mediaJson")
            })
        }
        composable("detail/{media}", arguments = listOf(navArgument("media") {type = NavType.StringType})
        ) { backStackEntry ->

            val mediaJson = backStackEntry.arguments?.getString("media")
            val media = Gson().fromJson(mediaJson, Media::class.java)

            DetailPage(media = media, navController = navController)
        }
    }
}

