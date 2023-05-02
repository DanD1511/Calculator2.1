package com.dand0129.calculator21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dand0129.calculator21.ui.theme.Calculator21Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainActivityViewModel by viewModels()
        setContent {
            Calculator21Theme {
                Calculator(viewModel)
            }
        }
    }
}
