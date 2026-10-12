package com.example.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.notesapp.ui.theme.NotesAppTheme

class AddNotes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val notes = remember { mutableStateListOf<String>("Test 1", "Test 2", "Test 3", "Test 4") }
                    val addNote: (String) -> Unit = {
                        notes.add(it)
                    }
                    val note = remember { mutableStateOf("") }
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Column {
                            TextField(note.value, onValueChange = {
                                note.value = it
                            }, label = {
                                CustomText("Add note here...")
                            })
                            Button(onClick = {
                                if (note.value.isNotEmpty()) {
                                    addNote(note.value)
                                } else {
                                    Toast.makeText(this@AddNotes, "Please enter a note", Toast.LENGTH_SHORT).show()
                                }
                            }) {
                                CustomText("Add Note")
                            }
                        }
                    }
                }
            }
        }
    }
}