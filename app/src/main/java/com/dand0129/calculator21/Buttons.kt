package com.dand0129.calculator20

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            },
            shape = CircleShape,
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .clip(CircleShape)
                .border(
                    width = 1.5.dp,
                    color = Color.DarkGray,
                    shape = CircleShape
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF363636)
            )
        ) {
            Text(
                text = number,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

// Delete Button

@Composable
fun DeleteButton(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = { onButtonClicked() },
        shape = CircleShape,
        modifier = Modifier
            .height(70.dp)
            .width(70.dp)
            .clip(CircleShape)
            .border(
                width = 1.5.dp,
                color = Color.DarkGray,
                shape = CircleShape
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF363636)
        )
    ) {
        Text(
            text = "⌫",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF0080ff)
        )
    }
}

@Composable
fun OperationButtons(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit,
    operation: String
) {
    Button(
        onClick = { onButtonClicked() },
        shape = CircleShape,
        modifier = Modifier
            .height(70.dp)
            .width(70.dp)
            .clip(CircleShape)
            .border(
                width = 1.5.dp,
                color = Color.DarkGray,
                shape = CircleShape
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF363636)
        )
    ) {
        Text(
            text = operation,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF0080ff)
        )
    }
}

@Composable
fun ResultButton(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = { onButtonClicked() },
        modifier = Modifier
            .height(70.dp)
            .width(220.dp)
            .border(
                width = 1.5.dp,
                color = Color(0xE1414AFF),
                shape = CircleShape
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0080ff)
        )
    ) {
        Text(
            text = "=",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun ClearButton(
    viewModel: MainActivityViewModel,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = { onButtonClicked() },
        shape = CircleShape,
        modifier = Modifier
            .height(70.dp)
            .width(70.dp)
            .clip(CircleShape)
            .border(
                width = 1.5.dp,
                color = Color.DarkGray,
                shape = CircleShape
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF363636)
        )
    ) {
        Text(
            text = "C",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF0080ff)
        )
    }
}

