package com.example.notesapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

public class MockNotes: ViewModel() {
    public val mockList = mutableStateListOf<String>("Test 1", "Test 2", "Test 3", "Test 4")

    fun addNotes(note: String) {
        mockList.add(note)
    }

    fun deleteNote(note: String) {
        mockList.remove(note)
    }
}