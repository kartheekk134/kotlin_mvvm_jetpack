package com.kotlinlearning

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MyFirstScreen(context: Context) {
//    var textChange = remember { mutableStateOf("Click Me") }
    var bgColor = remember { mutableStateOf(Color.Black) }
    var clicked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor.value)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentDescription = "Profile Image",
            painter = painterResource(id = R.drawable.circle),
            modifier = Modifier
                .padding(5.dp)
                .size(100.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Welcome to Jetpack Compose", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            clicked.value = !clicked.value
            if (clicked.value) {
                bgColor.value = Color.Red
            } else {
                bgColor.value = Color.Black
            }
        }) {
            Text("Click Me")
        }
        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb1PgGBYP5C94pjXXZH0H8OiedHj5x42rkLQ&s",
            contentDescription = "Another Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            error = painterResource(R.drawable.ic_launcher_background)
        )

//        ProfileCard()
    }
}