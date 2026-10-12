package com.example.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val notes = remember { mutableStateListOf<String>("Test 1", "Test 2", "Test 3", "Test 4") }

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text("Notes App", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        LazyColumn(modifier = Modifier.padding(PaddingValues(10.dp, 0.dp, 10.dp, 0.dp))) {
                            items(notes.size) {
                                CustomText(notes[it])
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotesAppTheme {
        CustomText("Android")
    }
}