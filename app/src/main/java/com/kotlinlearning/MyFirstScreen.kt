package com.kotlinlearning

import android.content.Context
import android.inputmethodservice.Keyboard.Row
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
    /*Column(
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
        )*/

//        ProfileCard()
//            Challenge2(context)
//            Counter()
//    ShowList()
//    showMutableList()
    TODOList()
}


@Composable
fun Challenge2(context: Context) {
    val buttonText = remember { mutableStateOf("This is Sample test BOX") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is Challenge 2", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                buttonText.value = "Button1 Clicked"
                Toast.makeText(context, "Button1 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Button1", color = Color.Green)
            }

            Button(onClick = {
                buttonText.value = "Button2 Clicked"
                Toast.makeText(context, "Button2 Clicked", Toast.LENGTH_SHORT).show()

            }) {
                Text(text = "Button2", color = Color.Red)
            }

            Button(onClick = {
                buttonText.value = "Button3 Clicked"
                Toast.makeText(context, "Button3 Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Button3", color = Color.DarkGray)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .background(Color.Magenta),
            Alignment.Center,
        ) {
            Text(buttonText.value)
        }
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Count: ${count.value}")
        Button(onClick = { count.value++ }) {
            Text("Increment")
        }
    }
}

@Composable
fun ShowList() {
    val items = listOf("Apple", "Banana", "Grape", "Papaya")

    LazyColumn {
        items(items) { item ->
            Text(text = item, fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
    }

}

@Composable
fun showMutableList() {
    val items = remember { mutableStateOf(listOf("Apple", "Banana", "Grape", "Papaya")) }

    Column {
        Button(onClick = {
            items.value = items.value + "New Task"
        }) {
            Text("Add Task")
        }

        LazyColumn {
            items(items.value) { task ->
                Text(task, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun TODOList() {
    val items = remember { mutableStateOf(listOf("Apple", "Banana", "Grape", "Papaya")) }
    val text = remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text("Enter Task") },
            placeholder = { Text("Type here...") }
        )

        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                if (!text.value.equals("")) {
                    items.value = items.value + text.value
                }
            },
        ){
            Text("Add Task", modifier = Modifier.padding(8.dp))
        }

        LazyColumn {
            items(items.value) { task ->
                Text(task, modifier = Modifier.padding(8.dp))
            }
        }
    }
}