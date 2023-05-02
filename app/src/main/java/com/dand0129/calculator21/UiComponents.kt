package com.dand0129.calculator21

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dand0129.calculator20.ClearButton
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
    Box(
        modifier = modifier
    ) {
        Text(
            text = displayValue.value,
            color = Color.White,
            fontSize = 60.sp,
            modifier = Modifier.horizontalScroll(rememberScrollState())
        )
    }
}

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    viewModel: MainActivityViewModel
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Row() {
                ClearButton(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.clearDisplay() }
                )
                Spacer(modifier = Modifier.width(10.dp))
                OperationButtons(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.operation("÷") },
                    operation = "÷"
                )
                Spacer(modifier = Modifier.width(10.dp))
                OperationButtons(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.operation("X") },
                    operation = "X"
                )
                Spacer(modifier = Modifier.width(10.dp))
                DeleteButton(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.deleteDisplay() }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                NumericButtons(
                    viewModel = viewModel,
                    number = "7",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    viewModel = viewModel,
                    number = "8",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    viewModel = viewModel,
                    number = "9",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                OperationButtons(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.operation("-") },
                    operation = "-"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                NumericButtons(
                    viewModel = viewModel,
                    number = "4",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    viewModel = viewModel,
                    number = "5",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    viewModel = viewModel,
                    number = "6",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                OperationButtons(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.operation("+") },
                    operation = "+"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                NumericButtons(
                    viewModel = viewModel,
                    number = "1",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    viewModel = viewModel,
                    number = "2",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    viewModel = viewModel,
                    number = "3",
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                NumericButtons(
                    number = ".",
                    viewModel = viewModel,
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                NumericButtons(number = "0",
                    viewModel = viewModel,
                    onButtonClicked = { number ->
                        viewModel.getNumber(number)
                    })
                Spacer(modifier = Modifier.width(10.dp))
                ResultButton(
                    viewModel = MainActivityViewModel(),
                    onButtonClicked = { viewModel.result() }
                )
            }
        }
    }
}
