package com.example.minder.presentation.navigation

import com.example.minder.R

sealed class Screen(val route : String, val icon : Int, val title : String){
    object MainScreen:Screen(route = "main_screen", icon = R.drawable.ic_all, title = "my logs")
    object CalendarScreen:Screen(route = "calendar_screen", icon = R.drawable.ic_calendar, title = "calendar")
    object ProfileScreen:Screen(route = "profile_screen", icon = R.drawable.ic_profile, title = "me")
    object NotesScreen:Screen(route = "notes_screen", icon = R.drawable.ic_note, title = "my notes")
    object TasksScreen:Screen(route = "tasks_screen", icon = R.drawable.ic_task, title = "my tasks")
    object TrackerScreen:Screen(route = "trackers_screen", icon = R.drawable.ic_tracker, title = "my trackers")

    object BottomScreens {
        val list = listOf(
            MainScreen, CalendarScreen, ProfileScreen
        )
    }
}
