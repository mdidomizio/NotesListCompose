package com.example.composesevennoteapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EE,d MMM hh:mm aaa", Locale.getDefault())
    return format.format(date)

}