package com.example.compose_sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay


class MainActivityPhilipp10 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val text by remember {
                mutableStateOf("")
            }
            LaunchedEffect(key1 = text) {
                delay(1200L)
                println("The text is $text")
            }

            DerivedStateDemo()
        }
    }
}


@Composable
fun DerivedStateDemo() {
    var counter by remember {
        mutableStateOf(0)
    }
    val counterText by remember {
        derivedStateOf {
            "The counter is $counter"
        }
    }
    Button(onClick = { counter++}) {
        Text(text = counterText)
    }
}

