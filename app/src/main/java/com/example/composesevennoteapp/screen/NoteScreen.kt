package com.example.composesevennoteapp.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesevennoteapp.R
import com.example.composesevennoteapp.components.NoteButton
import com.example.composesevennoteapp.components.NoteInputText
import com.example.composesevennoteapp.data.NoteDataSource
import com.example.composesevennoteapp.model.Note
import com.example.composesevennoteapp.util.formatDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
        ){
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current //way for getting a context eg for a Toast
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        },
            actions = {
            Icon(imageVector = Icons.Rounded.Notifications,
                contentDescription = "Icon")
        },
            backgroundColor = Color(color = 0xFFDADFE3))

        //content
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if(it.all{char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                })

            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp),
                text = description,
                label = "Add a note",
                onTextChange = {
                    //l' if serve a validare il testo
                    if(it.all{char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                })

            NoteButton(text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()){
                        onAddNote(Note(title = title, description = description))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                    }
               })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
            items(notes){note ->
               NoteRow(note = note,
                   onNoteClicked = {
                       onRemoveNote(note)
                   })
                
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit){
    Surface(modifier = Modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
        color = Color(color = 0XFFDFE6EB),
        elevation = 6.dp) {
        Column(modifier = Modifier
            .clickable { onNoteClicked(note) }
            .padding(
                horizontal = 14.dp,
                vertical = 6.dp
            ),
        horizontalAlignment = Alignment.Start) {
            Text(text = note.title,
                style = MaterialTheme.typography.subtitle2)
            Text(text = note.description,
                style = MaterialTheme.typography.subtitle1)
            Text(text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.caption)

        }

    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview (showBackground = true)
@Composable
fun NotesScreenPreview(){
    NoteScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}