package com.dand0129.calculator21

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class CalculatorUi: ComponentActivity() {
}
@Composable
fun Calculator(
    viewModel: MainActivityViewModel
){
    Column {
        Display(viewModel = viewModel)
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier.aspectRatio(1f)
        ) {
            Keyboard(viewModel = viewModel, modifier = Modifier.size(50.dp))
        }
    }
}

