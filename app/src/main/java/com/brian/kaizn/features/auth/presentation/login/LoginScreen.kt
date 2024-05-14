package com.brian.kaizn.features.auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.kaizn.R


class LoginScreen {

}

@Composable
fun Login(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
                text = "Login",
                fontSize = 40.sp,
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )
            // Password field with icon
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.password_icon),
                        contentDescription = null
                    )
                }
            )

            // Reset password link
            Text(
                text = "Forgot your password?",
//            style = MaterialTheme.typography.body2,

                modifier = Modifier
                    .clickable { TODO() }
                    .align(alignment = Alignment.End)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login button
            Button(
                onClick = { /* Handle login click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Register prompt
            Text(
                text = "New user? Register here",
//            style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .clickable { /* Handle register click */ }
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    Login()
}