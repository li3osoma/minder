package com.example.minder.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.minder.R
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.utils.Constants

@Composable
@Preview(showBackground = true)
fun CalendarBar(
    week:List<Day> = Constants.dayListMocked
){
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        items(week){day ->
            CalendarDayItem(day)
        }
    }

}
@Composable
//@Preview(showBackground = true)
fun CalendarDayItem(
    day:Day
){
    Card(modifier = Modifier,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            if (day.isChosen){
                Color(0xFFD2E6FF)
            }else{ Color.White}
        )
    ){
        Column(
            modifier = Modifier
                .width(50.dp)
                .height(76.dp)
                .padding(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = day.dayOfMonth.toString(),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_bold)),
                    color = DarkGrey
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = day.dayOfWeek,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_bold)),
                    color = DarkGrey
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            if(day.isToday){
                Image(
                    painter = painterResource(id = R.drawable.ic_dot),
                    contentDescription = "dot"
                )
            }
        }
    }
}



data class Day(
    val dayOfMonth:Int,
    val dayOfWeek:String,
    val isToday:Boolean,
    val isChosen:Boolean
)