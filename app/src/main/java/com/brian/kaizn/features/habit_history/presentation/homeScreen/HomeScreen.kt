package com.brian.kaizn.features.habit_history.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.brian.kaizn.R
import com.brian.kaizn.features.dashboard.NavDashboard

@Composable
fun Home(
    modifier: Modifier = Modifier,
    userName: String,
    profileImageResId: Int,
    ) {

    var habitName by remember { mutableStateOf("") }
    var habitProgress by remember { mutableStateOf(0) }
    var habitDate by remember { mutableStateOf("") }
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Custom greeting
            Text(
                text = "Welcome, $userName!\nLets Build some habits!",
//            style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(all = 16.dp),
                softWrap = true

            )

            // Circular profile image
            Image(
                painter = painterResource(profileImageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
//                        .align(Alignment.TopStart)
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
            items(daysOfWeek) { day ->
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = day)
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(all = 16.dp),
//                    .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(all = 16.dp),
                text = "Your Habits",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.padding(all = 16.dp),
                text = "Your Progress: 75%",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                        .height(320.dp)
            )
            {
                //Graph
            }
        }

        // Add Entry button
        FloatingActionButton(
            onClick = { navController.navigate("AddEntry") },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Entry"
            )
        }
//        NavDashboard()
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    Home(modifier = Modifier, userName = "Brian", profileImageResId = R.drawable.apex)
}

