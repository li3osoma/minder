package com.example.minder.presentation.trackers

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import com.example.minder.R
import com.example.minder.model.Tracker
import com.example.minder.utils.Constants
import kotlin.math.sqrt

@Composable
//@Preview(showBackground = true)
fun TrackerItem(
    tracker:Tracker
){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            Color.Transparent
        ),
        border = BorderStroke(2.dp, Color.DarkGray)
    ){
        Box(modifier = Modifier
            .wrapContentSize()
            .drawBehind {
                drawCircle(
                    color = Color(tracker.color),
                    radius = (tracker.doneNum/(tracker.days/1f))
                            *sqrt((size.height*size.height) +(size.width*size.width)),
                    center = Offset(x = 0f, y = 0f)
                )
            }
        ){
            Column(modifier = Modifier
                .wrapContentSize()
                .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = tracker.title,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenir_bold)),
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    ),
                    textAlign = TextAlign.End
                )
                Text(
                    text = "${tracker.doneNum}/${tracker.days}",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenir_bold)),
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    ),
                    textAlign = TextAlign.End
                )
            }
        }
//        Row(
//            modifier = Modifier
//                .height(74.dp)
//                .wrapContentHeight()) {
//            Canvas(modifier = Modifier.fillMaxSize()) {
//                drawCircle(
//                    color = Color(tracker.color),
//                    radius = (tracker.doneNum/tracker.days)
//                            * sqrt((size.height*size.height)+(size.width*size.width)),
//                    center = Offset(0f, 0f)
//                )
//            }
////            Box(
////                modifier = Modifier
////                    .padding(2.dp)
////                    .clip(CircleShape)
////                    .size(70.dp)
////                    .background(Color(tracker.color))
////                    .padding(7.dp)
////                    .clip(CircleShape)
////                    .background(Color.White),
////                contentAlignment = Alignment.Center
////            ) {
////            }
//            Column(modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .padding(15.dp),
//                verticalArrangement = Arrangement.SpaceBetween){
//                Text(
//                    text = tracker.title,
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    style = TextStyle(
//                        fontFamily = FontFamily(Font(R.font.avenir_bold)),
//                        fontSize = 16.sp,
//                        color = Color.DarkGray
//                    ),
//                    textAlign = TextAlign.End
//                )
//                Text(
//                    text = "${tracker.doneNum}/${tracker.days}",
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    style = TextStyle(
//                        fontFamily = FontFamily(Font(R.font.avenir_bold)),
//                        fontSize = 16.sp,
//                        color = Color.DarkGray
//                    ),
//                    textAlign = TextAlign.End
//                )
//            }
//        }

    }
}


