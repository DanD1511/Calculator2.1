package com.dand0129.calculator20


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dand0129.calculator21.MainActivityViewModel

// Numeric buttons

@Composable
fun NumericButtons(
    number: String,
    onButtonClicked: (String) -> Unit,
    viewModel: MainActivityViewModel
) {
    val number1 = remember { mutableStateOf("") }
    Box(modifier = Modifier.aspectRatio(10f)) {
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

