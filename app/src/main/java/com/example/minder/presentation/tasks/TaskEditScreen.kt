package com.example.minder.presentation.tasks

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minder.MainActivity
import com.example.minder.R
import com.example.minder.presentation.utils.MinderDatePickerDialog
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.utils.DateTimeUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun TaskEditScreen(
    isDateDialogShow:Boolean = false
){

    val activity = LocalContext.current as MainActivity

    val title = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }

    val isDeadline = remember {
        mutableStateOf(false)
    }
    
    val deadline = remember {
        mutableStateOf(0)
    }

    val category = remember {
        mutableStateOf(0)
    }



    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(20.dp)){
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = title.value,
            onValueChange = {
                title.value = it
            },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenir_regular)),
                color = DarkGrey,
                fontSize = 14.sp
            )
        )
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text (
                text = "Set deadline",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_regular)),
                    color = DarkGrey,
                    fontSize = 20.sp
                ),
            )
            Switch(checked = false, onCheckedChange = {})
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {}
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ){
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_calendar_day),
                    contentDescription = "set deadline",
                    alignment = Alignment.Center
                )
                ClickableText(
                    text = AnnotatedString(DateTimeUtils.getCurrentDateString()),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenir_regular)),
                        color = DarkGrey,
                        fontSize = 18.sp
                    ),
                    onClick = {}
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ){
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "set deadline",
                    alignment = Alignment.Center
                )
                ClickableText(
                    text = AnnotatedString("00:00"),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenir_regular)),
                        color = DarkGrey,
                        fontSize = 18.sp
                    ),
                    onClick = {}
                )
            }
        }

        ClickableText(
            modifier = Modifier
                .padding(top = 20.dp),
            text = AnnotatedString("+ Add category"),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenir_regular)),
                color = DarkGrey,
                fontSize = 20.sp
            ),
            onClick = {}
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = description.value,
            onValueChange = {
                description.value = it
            },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenir_regular)),
                color = DarkGrey,
                fontSize = 14.sp
            )
        )
    }
}