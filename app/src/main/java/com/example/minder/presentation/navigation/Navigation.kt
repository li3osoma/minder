package com.example.minder.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.minder.presentation.calendarScreen.CalendarScreen
import com.example.minder.presentation.mainScreen.MainScreen
import com.example.minder.presentation.notes.NotesScreen
import com.example.minder.presentation.profileScreen.ProfileScreen
import com.example.minder.presentation.tasks.TasksScreen
import com.example.minder.presentation.trackers.TrackersScreen

object NavigationRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.MainScreen)
}

@Composable
fun Navigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
            NavigationRouter.currentScreen.value = Screen.MainScreen
        }
        composable(route = Screen.CalendarScreen.route){
            CalendarScreen(navController = navController)
            NavigationRouter.currentScreen.value = Screen.CalendarScreen
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
            NavigationRouter.currentScreen.value=Screen.ProfileScreen
        }
        composable(Screen.NotesScreen.route){
            NotesScreen(navController = navController)
            NavigationRouter.currentScreen.value=Screen.NotesScreen
        }
        composable(Screen.TasksScreen.route){
            TasksScreen(navController = navController)
            NavigationRouter.currentScreen.value=Screen.TasksScreen
        }
        composable(Screen.TrackerScreen.route){
            TrackersScreen(navController = navController)
            NavigationRouter.currentScreen.value=Screen.TrackerScreen
        }
    }
}