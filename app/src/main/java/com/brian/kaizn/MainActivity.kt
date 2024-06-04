package com.brian.kaizn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.brian.kaizn.features.auth.presentation.login.Login
import com.brian.kaizn.features.dashboard.NavDashboard
import com.brian.kaizn.features.habit_history.presentation.homeScreen.Home
import com.brian.kaizn.features.navigation.AppNavigationHost
import com.brian.kaizn.ui.theme.KaiznTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaiznTheme{
                val navHostController  = rememberNavController()
                // A surface container using the 'background' color from the theme
                    AppNavigationHost(navController = navHostController, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KaiznTheme {
        Login(
            modifier = Modifier,
            onLoggedIn = {},
            onRegister = {}
        )
    }
}