package com.example.composesevennoteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composesevennoteapp.screen.NoteScreen
import com.example.composesevennoteapp.screen.NoteViewModel
import com.example.composesevennoteapp.ui.theme.ComposeSevenNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSevenNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel = viewModel<NoteViewModel>()
                    //val noteViewModel: NoteViewModel by viewModels() __-> 'e l'equivalente dela linea che c'e sopra
                    NotesApp(noteViewModel = noteViewModel)
            }
        }
    }
}
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(notes = notesList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.deleteNote(it) })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSevenNoteAppTheme {

    }
}