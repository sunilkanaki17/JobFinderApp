package com.appdevelopment.jobfinderapp.layout


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState",
    "RememberReturnType"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferencesScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Preferences") },
            )
        }
    ) {
        var role by remember { mutableStateOf("") }
        var location by remember { mutableStateOf("") }
        var experience by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),  // Adjusted padding for better layout
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Role TextField with rounded corners and improved spacing
            OutlinedTextField(
                value = role,
                onValueChange = { role = it },
                label = { Text("Role") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Space between fields
                shape = MaterialTheme.shapes.medium, // Rounded corners
                singleLine = true
            )

            // Location TextField with similar styling
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Space between fields
                shape = MaterialTheme.shapes.medium, // Rounded corners
                singleLine = true

            )

            // Experience TextField with similar styling
            OutlinedTextField(
                value = experience,
                onValueChange = { experience = it },
                label = { Text("Experience") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Space between fields
                shape = MaterialTheme.shapes.medium, // Rounded corners
                singleLine = true

            )

            // Add more UI elements here if needed, like a button or other fields
        }
    }
}
