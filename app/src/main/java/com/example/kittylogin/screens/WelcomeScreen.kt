package com.example.kittylogin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kittylogin.R

@Composable
fun WelcomeScreen(name: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF9800)) // Orange background
            .padding(16.dp),
        verticalArrangement = Arrangement.Top, // Align items to the top
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp)) // Top spacing

        Text(
            text = "Welcome, $name! 🐱",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.White
            ),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Text(
            text = "Email: $email",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            ),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Welcome Image",
            modifier = Modifier
                .size(700.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(100.dp))
    }
}
