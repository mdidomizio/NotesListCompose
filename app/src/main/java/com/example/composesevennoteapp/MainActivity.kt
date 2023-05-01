package com.example.composesevennoteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composesevennoteapp.data.NoteDataSource
import com.example.composesevennoteapp.model.Note
import com.example.composesevennoteapp.screen.NoteScreen
import com.example.composesevennoteapp.ui.theme.ComposeSevenNoteAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSevenNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val notes = remember {
                        mutableStateListOf<Note>()
                    }
                    NoteScreen(notes = notes,
                        onAddNote = {
                                    notes.add(it)
                        },
                        onRemoveNote = {
                            notes.remove(it)
                        })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSevenNoteAppTheme {

    }
}