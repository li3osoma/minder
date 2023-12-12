package com.example.minder.presentation.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minder.R
import com.example.minder.model.Note
import com.example.minder.presentation.utils.CalendarBar
import com.example.minder.presentation.utils.CategoryBar
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.utils.Constants

@Composable
//@Preview(showBackground = true)
fun NotesScreen(
    navController:NavController,
    notes:List<Note> = Constants.noteListMocked
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        CalendarBar()
        CategoryBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 3.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "notes_arrow_back",
                    tint = DarkGrey
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "my notes",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 24.sp,
                    color = Color.DarkGray
                )
            )
        }
        NotesContent(notes = notes)
    }
}

@Composable
fun NotesContent(
    notes:List<Note>
){
    LazyColumn(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 16.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(notes){note ->
            NoteItem(note)
        }
    }
}