package com.brian.kaizn.features.habit_history.presentation.habitDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.kaizn.R
import kotlinx.coroutines.delay


@Composable
fun HabitDetail(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    var progress by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        while (progress < 1f) {
            delay(100)  // Simulate some work being done
            progress += 0.01f
        }
    }
    Surface {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .padding(all = 6.dp),
                style = MaterialTheme.typography.titleLarge,
                text = "Habit Name",
                fontSize = 40.sp,
            )
            ProgressBarWithPercentage(progress = progress)

            Text(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .align(Alignment.Start),
                fontStyle = FontStyle.Italic,
                text = "Keep Going, \n" +
                        "You are doing great!",
                fontSize = 16.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.padding(end = 8.dp),
                    painter = painterResource(id = R.drawable.waves),
                    contentDescription = "Target"
                )
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = "Target: ",
                    fontSize = 24.sp,
                )

            }

            //graph visualizing the progress. Eg an hourglass filling with sand


            FloatingActionButton(
                onClick = onClick,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.End)

            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Add Entry"
                )
            }
        }
    }


}

@Composable
fun ProgressBarWithPercentage(progress: Float) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "${(progress * 100).toInt()}%")
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    HabitDetail(
        onClick = {}
    )
}
