package com.example.compose_sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


class MainActivityPhilipp9 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val guideLine = createGuidelineFromTop(
                    0.5f
                )

                constrain(greenBox) {
                    top.linkTo(guideLine)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(
                    greenBox,
                    redBox,
                    chainStyle = ChainStyle.Spread
                )
            }

            ConstraintLayout(
                constraintSet = constraints,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier
                    .background(color = Color.Green)
                    .layoutId("greenBox")
                )
                Box(modifier = Modifier
                    .background(color = Color.Red)
                    .layoutId("redBox")
                )
            }
        }
    }
    
}

