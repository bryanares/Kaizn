package com.brian.kaizn.features.dashboard

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brian.kaizn.R
import com.brian.kaizn.features.habit_history.presentation.homeScreen.Home

@Composable
fun KaiznBottomBar(
    navController: NavHostController,
//    modifier: Modifier = Modifier.height(50.dp)

) {
    NavigationBar() {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("Home") },
            icon = {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("History") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.history),
                    contentDescription = "History"
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("Profile") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile"
                )
            }
        )
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    return currentDestination?.route
}

