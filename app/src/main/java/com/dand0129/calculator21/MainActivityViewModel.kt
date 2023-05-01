package com.dand0129.calculator21

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _number1 = MutableLiveData<String>("")
    private val _number2 = MutableLiveData<String>("")
    private val _currentOperation = MutableLiveData("")
    private val _textToDisplay = MutableLiveData<String>("")
    private val _ans = MutableLiveData<String>("")
    private val _answer = MutableLiveData<String>("")

    fun getNumber(number: String) {
        _textToDisplay.value += number
        _number1.value += number
    }


    fun observeDisplayValue(onDisplayValueChanged: (String) -> Unit) {
        _textToDisplay.observeForever { newValue ->
            onDisplayValueChanged.invoke(newValue)
        }
    }

    fun deleteDisplay() {
        _textToDisplay.value = _textToDisplay.value!!.dropLast(1)
    }

    fun operation(operation: String) {
        _textToDisplay.value += operation
        if (_number1.value!!.isNotEmpty() && _number2.value!!.isEmpty()) {
            _number2.value = _number1.value
            _number1.value = ""
            _currentOperation.value = operation
        } else if (_number1.value!!.isNotEmpty() &&
            _number2.value!!.isNotEmpty()
        ) {
            _ans.value = calculateResult(
                _number2.value!!.toDouble(),
                _number1.value!!.toDouble(),
                _currentOperation.value!!
            ).toString()
            _number2.value = _ans.value
            _number1.value = ""
            _currentOperation.value = operation
        }
    }

    fun calculateResult(number1: Double, number2: Double, operation: String): Double {
        var currentResult = 0.0
        when (operation) {
            "+" -> currentResult = number1 + number2
            "-" -> currentResult = number1 - number2
            "X" -> currentResult = number1 * number2
            "÷" -> currentResult = number1 / number2
        }
        return currentResult
    }

    fun result() {
        if (_number1.value!!.isNotEmpty() && _number2.value!!.isEmpty()) {
            _textToDisplay.value = _number1.value
        } else if (_number1.value!!.isNotEmpty() && _number2.value!!.isNotEmpty()) {
            _ans.value = calculateResult(
                _number2.value!!.toDouble(),
                _number1.value!!.toDouble(),
                _currentOperation.value!!
            ).toString()
            _answer.value = _ans.value
            _number1.value = _ans.value
            _number2.value = ""
        }
    }

    fun clearDisplay() {
        _textToDisplay.value = ""
        _number1.value = ""
        _number2.value = ""
        _ans.value = ""
    }
}
