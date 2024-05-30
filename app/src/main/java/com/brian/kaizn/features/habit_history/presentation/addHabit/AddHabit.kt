package com.brian.kaizn.features.habit_history.presentation.addHabit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.kaizn.R

class AddHabit {
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddHabitScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp
    var habitValue by remember { mutableStateOf(0) }
    var goalTextState by remember { mutableStateOf(TextFieldValue("")) }


    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                modifier = Modifier
                    .padding(all = 6.dp),
                style = MaterialTheme.typography.titleLarge,
                text = "Create New",
                fontSize = 40.sp,
            )

            Text(
                modifier = Modifier
                    .padding(all = 6.dp),
                style = MaterialTheme.typography.titleLarge,
                text = "Habit",
                fontSize = 40.sp,
            )
            //select habit
            Row(
                modifier = Modifier.padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = "Select Habit: ")
                }
                ElevatedButton(onClick = {
                    expanded = !expanded
                }) {
                    // Icon(if (expanded) R.drawable.arrow_drop_down else R.drawable.arrow_drop_up, contentDescription = "Expand/Collapse")
                    Icon(
                        if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Expand/Collapse"
                    )

                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(all = 26.dp)
                    .height(100.dp)

            ) {
                IconButton(
                    onClick = { habitValue-- },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(modifier = Modifier.size(48.dp),
                        painter = painterResource(id = R.drawable.remove),
                        contentDescription = "Decrease"
                    )
                }

                BasicTextField(
                    value = habitValue.toString(),
                    onValueChange = { newValue ->
                        habitValue = newValue.toIntOrNull() ?: 0
                    },
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 100.dp)
                )

                IconButton(
                    onClick = { habitValue++ },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(modifier = Modifier.size(48.dp),
                        painter = painterResource(id = R.drawable.add_box),
                        contentDescription = "Increase")
                }
            }

            Text(
                modifier = Modifier
                    .padding(all = 6.dp),
                style = MaterialTheme.typography.titleLarge,
                text = "Goal",
                fontSize = 40.sp,
            )
            Text(
                modifier = Modifier
                    .padding(all = 16.dp),
                fontStyle = FontStyle.Italic,
                text = "What would you like to achieve on building this habit?",
                fontSize = 16.sp,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextField(
                    value = goalTextState,
                    onValueChange = {
                        goalTextState = it
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.White, // Background color of the TextField
                        focusedIndicatorColor = Color.Transparent, // Hide the underline when focused
                        unfocusedIndicatorColor = Color.Transparent // Hide the underline when not focused
                    )

                )
            }
            // Add Entry button
            FloatingActionButton(
                onClick = onClick,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.End)
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
fun PreviewAddHabit() {
    AddHabitScreen(onClick = {})
}