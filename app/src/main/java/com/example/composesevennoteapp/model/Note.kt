package com.example.composesevennoteapp.model

import android.icu.text.CaseMap.Title
import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(), //serve a creare un uuid random
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
