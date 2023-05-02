package com.dand0129.calculator21

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class CalculatorUi : ComponentActivity()

@Composable
fun Calculator(
    viewModel: MainActivityViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Display(
            viewModel = viewModel,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 120.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .align(BottomCenter)
        ) {
            Keyboard(
                viewModel = viewModel,
                modifier =
                Modifier
                    .fillMaxSize()
                    .align(Center)
                    .background(
                        color = Color(0xFF101010),
                        shape = RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp
                        )
                    )
            )
        }
    }
}

