package com.dand0129.calculator21

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val _number1 = MutableLiveData<String>("")
    val number1: LiveData<String> get() = _number1

    private val _number2 = MutableLiveData(0)
    val number2: LiveData<Int> get() = _number2

    private val _textToDisplay = MutableLiveData<String>("1")
    val textToDisplay: LiveData<String> get() = _textToDisplay


    fun getNumber(number: String) {
        _number1.value = number
        _textToDisplay.value = number
    }


    fun observeDisplayValue(onDisplayValueChanged: (String) -> Unit) {
        _textToDisplay.observeForever { newValue ->
            onDisplayValueChanged.invoke(newValue)
        }
    }
}
