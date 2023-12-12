package com.example.minder.presentation.utils

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minder.R
import com.example.minder.ui.theme.DarkGrey
import com.example.minder.ui.theme.LightBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun CreateFab(){
    Scaffold {values ->
        FloatingActionButton(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .padding(values),
            shape = CircleShape,
            containerColor = LightBackground,
            contentColor = DarkGrey,
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = "create"
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun CreateNoteFab(){
    Scaffold {values ->
        FloatingActionButton(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .padding(values),
            shape = CircleShape,
            containerColor = LightBackground,
            contentColor = DarkGrey,
            onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_note),
                contentDescription = "create note")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun CreateTaskFab(){
    Scaffold {values ->
        FloatingActionButton(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .padding(values),
            shape = CircleShape,
            containerColor = LightBackground,
            contentColor = DarkGrey,
            onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_task),
                contentDescription = "create note")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun CreateTrackerFad(){
    Scaffold {values ->
        FloatingActionButton(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .padding(values),
            shape = CircleShape,
            containerColor = LightBackground,
            contentColor = DarkGrey,
            onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_tracker),
                contentDescription = "create note")
        }
    }
}


@Composable
fun FilterFabMenuItem(
    menuItem: FilterFabMenuItem,
    onMenuItemClick: (FilterFabMenuItem) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        //label
        FilterFabMenuLabel(label = menuItem.label)

        //fab
        FilterFabMenuButton(item = menuItem, onClick = onMenuItemClick)

    }

}


@Composable
fun FilterFabMenuButton(
    item: FilterFabMenuItem,
    onClick: (FilterFabMenuItem) -> Unit,
    modifier: Modifier = Modifier
) {

    FloatingActionButton(
        modifier = modifier,
        onClick = {
            onClick(item)
        },
        containerColor = LightBackground,
        contentColor = DarkGrey
    ) {
        Icon(
            painter = painterResource(item.icon),
            contentDescription = null,
            tint = DarkGrey
        )
    }
}


@Composable
fun FilterFabMenuLabel(
    label: String,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        color = Color.Black.copy(alpha = 0.8f)
    ) {
        Text(
            text = label, color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 2.dp),
            fontSize = 14.sp,
            maxLines = 1
        )
    }

}


@Composable
fun FilterFabMenu(
    visible: Boolean,
    items: List<FilterFabMenuItem>,
    modifier: Modifier = Modifier
) {

    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Bottom,
            animationSpec = tween(150, easing = FastOutSlowInEasing)
        ) + fadeIn(
            initialAlpha = 0.3f,
            animationSpec = tween(150, easing = FastOutSlowInEasing)
        )
    }

    val exitTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Bottom,
            animationSpec = tween(150, easing = FastOutSlowInEasing)
        ) + fadeOut(
            animationSpec = tween(150, easing = FastOutSlowInEasing)
        )
    }


    AnimatedVisibility(visible = visible, enter = enterTransition, exit = exitTransition) {
        Column(
            modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items.forEach { menuItem ->
                FilterFabMenuItem(
                    menuItem = menuItem,
                    onMenuItemClick = {}
                )
            }
        }
    }
}


@Composable
fun FilterFab(
    state: FilterFabState,
    rotation:Float,
    onClick: (FilterFabState) -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        modifier = modifier
            .rotate(rotation),
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
        onClick = {
            onClick(
                if (state == FilterFabState.EXPANDED) {
                    FilterFabState.COLLAPSED
                } else {
                    FilterFabState.EXPANDED
                }
            )
        },
        containerColor = LightBackground,
        shape = CircleShape
    ) {
        Icon(
            Icons.Default.Create,
            contentDescription = null,
            tint = DarkGrey
        )
    }

}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
@Preview(showBackground = true)
fun FilterView(
    items: List<FilterFabMenuItem> = filterFabs,
    modifier: Modifier = Modifier
) {

    var filterFabState by rememberSaveable() {
        mutableStateOf(FilterFabState.COLLAPSED)
    }

    val transitionState = remember {
        MutableTransitionState(filterFabState).apply {
            targetState = FilterFabState.COLLAPSED
        }
    }

    val transition = updateTransition(targetState = transitionState, label = "transition")

    val iconRotationDegree by transition.animateFloat({
        tween(durationMillis = 150, easing = FastOutSlowInEasing)
    }, label = "rotation") {
        if (filterFabState == FilterFabState.EXPANDED) 180f else 0f
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom)
    ) {
        FilterFabMenu(items = items, visible = filterFabState == FilterFabState.EXPANDED)
        FilterFab(
            state = filterFabState,
            rotation = iconRotationDegree, onClick = { state ->
                filterFabState = state
            })
    }
}

enum class FilterFabState{
    COLLAPSED,
    EXPANDED
}

data class FilterFabMenuItem(
    val label: String,
    val icon: Int
)

val filterFabs = listOf(
    FilterFabMenuItem(label = "Note", R.drawable.ic_note),
    FilterFabMenuItem(label = "Task", R.drawable.ic_task),
    FilterFabMenuItem(label = "Tracker", R.drawable.ic_tracker)
)