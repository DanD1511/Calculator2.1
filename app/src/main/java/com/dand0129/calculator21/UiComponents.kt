package com.dand0129.calculator21

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dand0129.calculator20.NumericButtons

@Composable
fun Display(
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel
) {
    val displayValue = remember { mutableStateOf("") }
    viewModel.observeDisplayValue { Value ->
        displayValue.value = Value
    }
    Box(modifier = Modifier.fillMaxWidth().background(color = Color.Cyan)) {
        Text(
            text = displayValue.value,
            color = Color.Black
        )
    }
}

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel
) {
    Column() {
        NumericButtons(
            viewModel = viewModel,
            number = "2",
            onButtonClicked = {number ->
                viewModel.getNumber(number)
            })
    }
}
