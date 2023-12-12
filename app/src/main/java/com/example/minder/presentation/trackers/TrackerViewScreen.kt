package com.example.minder.presentation.trackers

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minder.R
import com.example.minder.model.Tracker
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.utils.Constants

@Composable
@Preview(showBackground = true)
fun TrackerView(
    tracker: Tracker = Constants.trackerMocked
){
    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(start = 20.dp, end = 20.dp)) {
        Text(
            text = tracker.title,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 10.dp, bottom = 20.dp),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenir_bold)),
                fontSize = 16.sp
            )
        )
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 15.dp)
                .wrapContentHeight()
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            columns = StaggeredGridCells.Fixed(5),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalItemSpacing = 20.dp,
        ){
            items(tracker.days){
                DotComposable(tracker.color, tracker.daysList[it])
            }
        }
        Text(
            text = tracker.description,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 20.dp),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenir_medium)),
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
//@Preview(showBackground = true)
fun DotComposable(
    color: Long = 0xFFFBF6AA,
    isChecked:Boolean = true
){

    var checkedState by remember {
        mutableStateOf(isChecked)
    }

//    Box(
//        modifier = Modifier
//            .clip(CircleShape)
//            .size(20.dp)
//            .background(Color.DarkGray)
//            .padding(1.dp)
//            .clip(CircleShape)
//            .background(Color(color))
//    )

    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                checkedState = !checkedState
            },
        onDraw = {
            drawCircle(
                color = DarkGrey,
                center = Offset.Zero,
                radius = 25.0f,
                style = Stroke(width = 5.0f)
            )
            drawCircle(
                color = if(checkedState){
                    Color(color)
                }else{
                    Color.White},
                center = Offset.Zero,
                radius = 23.0f,
                style = Fill
            )
        })
}