package com.example.compose_sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp


class MainActivityPhilipp5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.lora_regular, FontWeight.Thin),
            Font(R.font.lora_bold, FontWeight.Bold),
            Font(R.font.lora_bolditalic, FontWeight.Bold),
            Font(R.font.lora_italic, FontWeight.Thin),
            Font(R.font.lora_medium, FontWeight.Medium),
            Font(R.font.lora_mediumitalic, FontWeight.Medium),
            Font(R.font.lora_semibold, FontWeight.SemiBold),
            Font(R.font.lora_semibolditalic, FontWeight.SemiBold)
        )

        setContent {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF101010))
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ) {
                            append("H")
                        }
                        append("ello ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ) {
                            append("W")
                        }
                        append("orld!")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Thin,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

