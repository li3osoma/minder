package com.example.minder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.minder.presentation.navigation.CustomBottomNavigation
import com.example.minder.presentation.navigation.Navigation
import com.example.minder.presentation.navigation.NavigationRouter
import com.example.minder.presentation.navigation.Screen
import com.example.minder.ui.theme.MinderTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            MinderTheme {
                // A surface container using the 'background' minderColor from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            when (NavigationRouter.currentScreen.value) {
                                Screen.NotesScreen,
                                Screen.TrackerScreen,
                                Screen.TasksScreen,
                                Screen.MainScreen,
                                Screen.CalendarScreen,
                                Screen.ProfileScreen -> {
                                    CustomBottomNavigation(currentScreenRoute = NavigationRouter.currentScreen.value.route) { screen ->
                                        if (screen.route != NavigationRouter.currentScreen.value.route) {
                                            NavigationRouter.currentScreen.value = screen
                                            navController.navigate(screen.route)
                                        }
                                    }
                                }
                                else -> {}
                            }
                        },
                    ) {
                            contentPadding ->
                        run {
                            Box(modifier = Modifier.padding(contentPadding)) {
                                Navigation(navController, applicationContext)
                            }
                        }
                    }

                }
            }
        }
    }
}