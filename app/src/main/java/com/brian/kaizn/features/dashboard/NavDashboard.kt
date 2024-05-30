package com.brian.kaizn.features.dashboard

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.kaizn.features.auth.presentation.login.Login
import com.brian.kaizn.features.auth.presentation.registration.Registration
import com.brian.kaizn.features.habit_history.presentation.addHabit.AddHabit
import com.brian.kaizn.features.habit_history.presentation.addHabit.AddHabitScreen
import com.brian.kaizn.features.habit_history.presentation.homeScreen.Home

//nav controller
@Composable
fun NavDashboard(modifier: Modifier = Modifier.fillMaxWidth()) {

    val navHostController = rememberNavController()
    Scaffold(modifier
        .fillMaxWidth(),
        bottomBar = {
        KaiznBottomBar(navController = navHostController)
    }) {

        NavDashboardDestinations(
            navHostController = navHostController,
            modifier = Modifier.padding(it),
        )
    }

}

@Composable
fun NavDashboardDestinations(modifier: Modifier = Modifier, navHostController: NavHostController) {

    //nav controller
    NavHost(navController = navHostController, startDestination = "Home") {
        composable(route = "Home") {
//            Home()
        }
    }
    NavHost(navController = navHostController, startDestination = "History") {
        composable(route = "History") {

        }
    }
    NavHost(navController = navHostController, startDestination = "Profile") {
        composable(route = "Profile") {

//            Text(text = "Profile")
        }
    }
    NavHost(navController = navHostController, startDestination = "Login") {
        composable(route = "Login") {
//            Login()
        }
    }
    NavHost(navController = navHostController, startDestination = "Registration") {
        composable(route = "Registration") {
//            Registration()
        }
    }
    NavHost(navController = navHostController, startDestination = "AddEntry") {
        composable(route = "AddEntry") {
//            AddHabitScreen{
//
//            }
        }
    }
}

