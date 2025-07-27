package com.kotlinlearning

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyFirstScreen() {
    Column {
        Text(text = "Welcome to Jetpack Compose", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}) {
            Text(text = "Click Me")
        }
    }
}