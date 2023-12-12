package com.example.minder.presentation.trackers

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun TrackerEditScreen(){

    val title = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }
    val daysNum = remember {
        mutableStateOf(0)
    }

    val doneNum = remember {
        mutableStateOf(0)
    }

    val startDate = remember {
        mutableStateOf(0)
    }

    val finishDate = remember {
        mutableStateOf(0)
    }
    
}