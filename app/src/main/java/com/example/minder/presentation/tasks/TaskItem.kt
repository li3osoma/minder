package com.example.minder.presentation.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minder.R
import com.example.minder.model.Task
import com.example.minder.utils.Constants

@Composable
//@Preview(showBackground = true)
fun TaskItem(
    task: Task
) {

    var doneState by remember {
        mutableStateOf(task.done)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(task.color))
            .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            CustomCheckBox(doneState, task.color)
            Text(
                text = task.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            )
        }
    }
}

@Composable
fun CustomCheckBox(
    doneState:Boolean = false,
    taskColor:Long){

    var isChecked by remember {
        mutableStateOf(doneState)
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(7.5.dp))
            .size(20.dp)
            .background(Color.DarkGray)
            .padding(1.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(taskColor)),
        contentAlignment = Alignment.Center
    ) {
        if(isChecked){
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "done")
        }
    }
}