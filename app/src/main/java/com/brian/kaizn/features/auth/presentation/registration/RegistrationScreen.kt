package com.brian.kaizn.features.auth.presentation.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RegistrationScreen {

}

@Composable
fun Registration(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Surface {
        Column(
            modifier = Modifier
                .padding(all = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                modifier = Modifier
                    .padding(all = 6.dp),
                style = MaterialTheme.typography.titleLarge,
                text = "Sign Up",
                fontSize = 40.sp,
            )
            // Username field
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

            // Email field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

            // Confirm password field
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Terms and conditions link
            Text(
                text = "Read our Terms and Conditions",
//            style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .clickable { }
                    .align(alignment = Alignment.End)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign up button
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Up")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login link
            Text(
                text = "Already have an account? Log in",
                modifier = Modifier
                    .clickable { }
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrationScreen() {
    Registration()
}