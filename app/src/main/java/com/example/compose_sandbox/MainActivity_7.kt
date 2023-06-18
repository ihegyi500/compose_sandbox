package com.example.compose_sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivityPhilipp7 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val snackbarHostState = remember { SnackbarHostState() }
            var tFState by remember { mutableStateOf("") }
            val scope = rememberCoroutineScope()

            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text("Top bar title") }
                    )
                },
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            ) { paddingValues ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    TextField(
                        value = tFState,
                        label = {
                             Text(text = "Enter your name")
                        },
                        onValueChange = {
                            tFState = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.75f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "Hello $tFState",
                                duration = SnackbarDuration.Long
                            )
                        }
                    }) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    }
}

