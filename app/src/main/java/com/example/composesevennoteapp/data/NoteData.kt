package com.example.composesevennoteapp.data

import com.example.composesevennoteapp.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "andorid compose", description = "working on compose app"),
            Note(title = "water", description = "drink 2l water"),
            Note(title = "sleep", description = "sleep at least 8h per night"),
            Note(title = "andorid compose", description = "working on compose app"),
            Note(title = "water", description = "drink 2l water"),
            Note(title = "sleep", description = "sleep at least 8h per night")
        )
    }
}