package com.dand0129.calculator21

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dand0129.calculator20.DeleteButton
import com.dand0129.calculator20.NumericButtons
import com.dand0129.calculator20.OperationButtons
import com.dand0129.calculator20.ResultButton

@Composable
fun Display(
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel
) {
    val displayValue = remember { mutableStateOf("") }
    viewModel.observeDisplayValue { Value ->
        displayValue.value = Value
    }
    Box() {
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
        Row(){
            OperationButtons(
                viewModel = MainActivityViewModel(),
                onButtonClicked = { viewModel.operation("+") },
                operation = "+")
            OperationButtons(
                viewModel = MainActivityViewModel(),
                onButtonClicked = { viewModel.operation("-") },
                operation = "-")
            OperationButtons(
                viewModel = MainActivityViewModel(),
                onButtonClicked = { viewModel.operation("X") },
                operation = "X")
            OperationButtons(
                viewModel = MainActivityViewModel(),
                onButtonClicked = { viewModel.operation("÷") },
                operation = "÷")
        }
        Row {
            NumericButtons(
                viewModel = viewModel,
                number = "1",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
            NumericButtons(
                viewModel = viewModel,
                number = "2",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
            NumericButtons(
                viewModel = viewModel,
                number = "3",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
        }
        Row {
            NumericButtons(
                viewModel = viewModel,
                number = "4",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
            NumericButtons(
                viewModel = viewModel,
                number = "5",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
            NumericButtons(
                viewModel = viewModel,
                number = "6",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
        }
        Row {
            NumericButtons(
                viewModel = viewModel,
                number = "7",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
            NumericButtons(
                viewModel = viewModel,
                number = "8",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
            NumericButtons(
                viewModel = viewModel,
                number = "9",
                onButtonClicked = { number ->
                    viewModel.getNumber(number)
                })
        }
        Row() {
            DeleteButton(
                viewModel = MainActivityViewModel(),
                onButtonClicked = { viewModel.deleteDisplay() }
            )
            ResultButton(
                viewModel = MainActivityViewModel(),
                onButtonClicked = {viewModel.result()}
            )
        }
    }
}
