package com.brian.kaizn.features.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//nav controller
@Composable
fun NavDashboard(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()
    Scaffold(bottomBar = {
        KaiznBottomBar(navController = navHostController)
    }) {

        NavDashboardDestinations(
            navHostController = navHostController,
            modifier = Modifier.padding(it)
        )
    }

}

@Composable
fun NavDashboardDestinations(modifier: Modifier = Modifier, navHostController: NavHostController) {

    //nav controller
    NavHost(navController = navHostController, startDestination = "Home") {
        composable(route = "Home") {
            Text(text = "Home")
        }
    }
    NavHost(navController = navHostController, startDestination = "History") {
        composable(route = "History") {

            Text(text = "History")
        }
    }
    NavHost(navController = navHostController, startDestination = "Profile") {
        composable(route = "Profile") {

            Text(text = "Profile")
        }
    }
}
