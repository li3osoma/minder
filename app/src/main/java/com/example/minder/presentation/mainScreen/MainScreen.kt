package com.example.minder.presentation.mainScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minder.R
import com.example.minder.model.Note
import com.example.minder.model.Task
import com.example.minder.model.Tracker
import com.example.minder.presentation.navigation.Screen
import com.example.minder.presentation.notes.NoteItem
import com.example.minder.presentation.tasks.TaskItem
import com.example.minder.presentation.trackers.TrackerItem
import com.example.minder.presentation.utils.CalendarBar
import com.example.minder.presentation.utils.CategoryBar
import com.example.minder.presentation.utils.FilterView
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.ui.theme.LightBackground
import com.example.minder.ui.theme.LightGray
import com.example.minder.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun MainScreen(
    navController: NavController,
    notes:List<Note> = Constants.noteListMocked,
    tasks:List<Task> = Constants.taskListMocked,
    trackers:List<Tracker> = Constants.trackerListMocked
){
    Column(modifier = Modifier
        .background(Color.White)) {
        CalendarBar()
        CategoryBar()
        Content(navController, notes, tasks, trackers)
    }
    FilterView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun Content(
    navController: NavController,
    notes:List<Note> = Constants.noteListMocked,
    tasks:List<Task> = Constants.taskListMocked,
    trackers:List<Tracker> = Constants.trackerListMocked
){

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 16.dp, end = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = "My notes",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 24.sp,
                    color = Color.DarkGray
                )
            )
            IconButton(onClick = {
                navController.navigate(Screen.NotesScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "notes_arrow",
                    tint = DarkGrey)
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(notes){note ->
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally)){
                    NoteItem(note)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 16.dp, end = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = "My tasks",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 24.sp,
                    color = Color.DarkGray
                )
            )
            IconButton(onClick = {
                navController.navigate(Screen.TasksScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "tasks_arrow",
                    tint = DarkGrey)
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            this.items(tasks.chunked(3)){taskList ->

                when(taskList.size){
                    3 ->{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(start = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            TaskItem(taskList[0])
                            TaskItem(taskList[1])
                            TaskItem(taskList[2])
                        }
                    }
                    2 ->{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(start = 16.dp, end = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ){
                            TaskItem(taskList[0])
                            TaskItem(taskList[1])
                        }
                    }
                    1 ->{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(start = 16.dp, end = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ){
                            TaskItem(taskList[0])
                        }
                    }
                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 16.dp, end = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = "My trackers",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 24.sp,
                    color = Color.DarkGray
                )
            )
            IconButton(onClick = {
                navController.navigate(Screen.TrackerScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "trackers_arrow",
                    tint = DarkGrey)
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .wrapContentHeight()
        ){
            this.items(trackers.chunked(2)){trackerList ->

                when(trackerList.size){
//                    3 ->{
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .wrapContentHeight()
//                                .padding(start = 16.dp),
//                            verticalArrangement = Arrangement.spacedBy(10.dp)
//                        ){
//                            TrackerItem(trackerList[0])
//                            TrackerItem(trackerList[1])
//                            TrackerItem(trackerList[2])
//                        }
//                    }
                    2 ->{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(start = 16.dp, end = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ){
                            TrackerItem(trackerList[0])
                            TrackerItem(trackerList[1])
                        }
                    }
                    1 ->{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(start = 16.dp, end = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ){
                            TrackerItem(trackerList[0])
                        }
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}





