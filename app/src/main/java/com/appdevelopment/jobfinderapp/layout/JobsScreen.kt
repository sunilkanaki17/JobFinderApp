package com.appdevelopment.jobfinderapp.layout

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.appdevelopment.jobfinderapp.Data.Job
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun JobsScreen() {
    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()
    val jobs = remember { mutableStateListOf<Job>() }

    LaunchedEffect(true) {
        db.collection("jobs")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val job = document.toObject(Job::class.java)
                    jobs.add(job)
                }
            }
    }

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            //val context = LocalContext.current
            items(jobs.size) { index ->
                val job = jobs[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = job.title.toString(), style = MaterialTheme.typography.titleMedium)
                        Text(text = "Company: ${job.company}")
                        Text(text = "Location: ${job.location}")
                        Text(text = "Posted: ${job.postedTime}")
                        Text(
                            text = "View Job",
                            color = Color.Blue,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .clickable {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(job.jobLink))
                                    context.startActivity(intent)
                                }
                                .padding(top = 8.dp)
                        )
                    }
                }
            }
        }
}
