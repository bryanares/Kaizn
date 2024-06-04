package com.brian.kaizn.features.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.kaizn.R
import com.brian.kaizn.features.habit_history.presentation.homeScreen.Home

//create the dashboard screen
//This screen hosts the navigation and the app screen composables
//when navigating screens this dashboard switches which screen is displayed


enum class DashboardNavigationDestinations {
    HOME,
    HISTORY,
    PROFILE

}

@Composable
fun Dashboard(onNewHabitClicked: (() -> Unit)? = null) {
    val dashBoardNavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar {
                DashboardNavigationDestinations.HOME.apply {
                    NavigationBarItem(selected = false, onClick = {
                        dashBoardNavHostController.navigate(DashboardNavigationDestinations.HOME.name)
                    }, icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home"
                        )
                    })
                }
                DashboardNavigationDestinations.HISTORY.apply {
                    NavigationBarItem(selected = false, onClick = {
                        dashBoardNavHostController.navigate(DashboardNavigationDestinations.HISTORY.name)
                    }, icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.history),
                            contentDescription = "History"
                        )
                    })
                }

                DashboardNavigationDestinations.PROFILE.apply {
                    NavigationBarItem(selected = false, onClick = {
                        dashBoardNavHostController.navigate(DashboardNavigationDestinations.PROFILE.name)
                    }, icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile"
                        )
                    })
                }

            }
        }
    ) {

        DashboardNavigationHost(
            modifier = Modifier.padding(it),
            navHostController = dashBoardNavHostController,
            onNewHabitClicked = onNewHabitClicked
        )
    }
}


@Composable
fun DashboardNavigationHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    onNewHabitClicked: (() -> Unit)? = null
) {

    NavHost(
        navController = navHostController,
        startDestination = DashboardNavigationDestinations.HOME.name
    ) {
        composable(DashboardNavigationDestinations.HOME.name) {
            Home(
                userName = "Brian",
                profileImageResId = R.drawable.apex,
                onClick = { onNewHabitClicked?.invoke() }
            )

        }
        composable(DashboardNavigationDestinations.HISTORY.name) {
            Text("History")
        }

        composable(DashboardNavigationDestinations.PROFILE.name) {
            Text("Profile")
        }
    }
}
