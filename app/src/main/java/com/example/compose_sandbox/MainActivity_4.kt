package com.example.compose_sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivityPhilipp4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(R.drawable.kermit)
            val description = "Kermit the Frog, drinking tea"
            val title = "Kermit is drinking tea"

            Box(modifier = Modifier
                .width(painter.intrinsicSize.width.dp)
                .padding(16.dp)
            ) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )
            }
        }
    }
}

@Preview
@Composable
fun ImageCardPreview() {
    val painter = painterResource(R.drawable.kermit)
    val description = "Kermit the Frog, drinking tea"
    val title = "Kermit is drinking tea"

    Box(modifier = Modifier
        .fillMaxWidth(0.75f)
        .padding(16.dp)
    ) {
        ImageCard(
            painter = painter,
            contentDescription = description,
            title = title
        )
    }
}

@Composable
fun ImageCard(
    painter : Painter,
    contentDescription : String,
    title : String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(300.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}