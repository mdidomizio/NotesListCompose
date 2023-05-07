package com.example.composesevennoteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composesevennoteapp.data.NoteDataSource
import com.example.composesevennoteapp.model.Note

class NoteViewModel: ViewModel() {
    private var noteList = mutableStateListOf<Note>()

   init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }
    fun removeNote( note: Note){
        noteList.remove(note)
    }
    fun getAllNotes(): List<Note> {
        return noteList
    }
}