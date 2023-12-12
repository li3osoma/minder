package com.example.minder.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.ui.theme.LightBackground
import com.example.minder.utils.Constants

@Composable
@Preview(showBackground = true)
fun CategoryBar(
    categories:List<Category> = Constants.categoryListMocked
){
    Row(verticalAlignment = Alignment.CenterVertically){
        LazyRow(modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            items(categories){category ->
                CategoryItem(category)
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "manage categories",
                tint = DarkGrey
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryItem(
    category: Category = Constants.categoryMocked
){
    OutlinedCard(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(),
        shape = RoundedCornerShape(15.dp),
    ){
        Row(modifier = Modifier
            .wrapContentWidth()
            .background(Color.White)
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(7.dp)){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(14.dp)
                    .background(Color(category.color))
            )
            Text(
                text = category.name,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenir_medium)),
                    fontSize = 14.sp,
                    color = DarkGrey
                )
            )
        }
    }
}

data class Category(
    val name:String,
    val color:Long
)