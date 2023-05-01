package com.example.composesevennoteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composesevennoteapp.screen.NoteScreen
import com.example.composesevennoteapp.screen.NoteViewModel
import com.example.composesevennoteapp.ui.theme.ComposeSevenNoteAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSevenNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)
            }
        }
    }
}
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList = noteViewModel.getAllNotes()

    NoteScreen(notes = notesList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.removeNote(it) })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSevenNoteAppTheme {

    }
}