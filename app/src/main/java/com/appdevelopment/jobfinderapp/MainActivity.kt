package com.appdevelopment.jobfinderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appdevelopment.jobfinderapp.layout.JobsScreen
import com.appdevelopment.jobfinderapp.layout.PreferencesScreen
import com.example.jobfinderapp.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JobFinderApp()
        }
    }
}

@Composable
fun JobFinderApp() {
    val navController = rememberNavController()

    // Define the navigation graph
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("preferences") { PreferencesScreen() }
        composable("jobs") { JobsScreen() }
    }
}

