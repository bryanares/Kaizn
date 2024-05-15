package com.brian.kaizn.features.habit_history.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.brian.kaizn.R

class HomeScreen {
//Add NavController to HomeScreen
}


@Composable
fun Home(modifier: Modifier = Modifier, userName: String, profileImageResId: Int,onClick: () -> Unit) {

    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(all = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Custom greeting
                Text(
                    text = "Welcome, $userName!\nLets Build some habits!",
//            style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    softWrap = true
                )

                // Circular profile image
                Image(
                    painter = painterResource(id = profileImageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopStart)
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
            FloatingActionButton(
                onClick = onClick,
                modifier = Modifier
//                    .align(Alignment.BottomEnd)
                    .align(Alignment.End)
                    .padding(16.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Entry"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    Home(userName = "John Doe", profileImageResId = R.drawable.apex, onClick = {})
}

