package com.brian.kaizn.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brian.kaizn.R
import com.brian.kaizn.features.auth.presentation.login.Login
import com.brian.kaizn.features.auth.presentation.registration.Registration
import com.brian.kaizn.features.dashboard.Dashboard
import com.brian.kaizn.features.habit_history.presentation.addHabit.AddHabit
import com.brian.kaizn.features.habit_history.presentation.addHabit.AddHabitScreen
import com.brian.kaizn.features.habit_history.presentation.homeScreen.Home


enum class AppDestinations {
    LOGIN,
    REGISTRATION,
    DASHBOARD,
    NEW_HABIT,
}

@Composable
fun AppNavigationHost(modifier: Modifier = Modifier, navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppDestinations.LOGIN.name) {
        composable(AppDestinations.LOGIN.name) {
            Login(onRegister = {
                navController.navigate(AppDestinations.REGISTRATION.name)
            }, onLoggedIn = {
                navController.navigate(AppDestinations.DASHBOARD.name)
            })
        }
        composable(AppDestinations.REGISTRATION.name) {
            Registration()
        }

        composable(AppDestinations.DASHBOARD.name) {
            Dashboard(){
                navController.navigate(AppDestinations.NEW_HABIT.name)
            }
        }
        composable(AppDestinations.NEW_HABIT.name) {
            AddHabitScreen(){

            }
        }
    }
}