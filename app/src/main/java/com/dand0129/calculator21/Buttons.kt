package com.dand0129.calculator20

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dand0129.calculator21.MainActivityViewModel

// Numeric buttons

@Composable
fun NumericButtons(
    number: String,
    viewModel: MainActivityViewModel,
    onButtonClicked: (String) -> Unit,
) {
    val number1 = remember { mutableStateOf("") }
    Box() {
        Button(
            onClick = {
                number1.value = number
                onButtonClicked(number1.value)
            }
        ) {
            Text(
                text = number
            )
        }
    }
}

// Delete Button

@Composable
fun DeleteButton(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit
){
    Button(onClick = {onButtonClicked()}) {
        Text(text = "DEL")
    }
}

@Composable
fun OperationButtons(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit,
    operation: String
){
    Button(onClick = {onButtonClicked()}) {
        Text(text = operation)
    }
}@Composable
fun ResultButton(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit
){
    Button(onClick = {onButtonClicked()}) {
        Text(text = "=")
    }
}

@Composable
fun ClearButton(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit
){
    Button(onClick = {onButtonClicked()}) {
        Text(text = "CLR")
    }
}

