package com.example.minder.presentation.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minder.R
import com.example.minder.model.Task
import com.example.minder.presentation.utils.CalendarBar
import com.example.minder.presentation.utils.CategoryBar
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.utils.Constants

@Composable
//@Preview(showBackground = true)
fun TasksScreen(
    navController: NavController,
    tasks:List<Task> = Constants.taskListMocked
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        CalendarBar()
        CategoryBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 3.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "tasks_arrow_back",
                    tint = DarkGrey
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "my tasks",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 24.sp,
                    color = Color.DarkGray
                )
            )
        }
        TasksContent(tasks = tasks)
    }
}

@Composable
fun TasksContent(
    tasks:List<Task>
){
    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(tasks){task ->
            TaskItem(task)
        }
    }
}