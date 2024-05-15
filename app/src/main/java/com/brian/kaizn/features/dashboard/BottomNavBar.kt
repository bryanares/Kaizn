package com.brian.kaizn.features.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun KaiznBottomBar(
    navController: NavHostController
) {
    NavigationBar() {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("History") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "History"
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("Profile") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Profile"
                )
            }
        )
    }
}

@Composable
fun currentRoute(navController: NavHostController) :String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    return currentDestination?.route
}

