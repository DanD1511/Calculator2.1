package com.dand0129.calculator21

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _number1 = MutableLiveData<String>("")
    val number1: LiveData<String> get() = _number1

    private val _number2 = MutableLiveData("")
    val number2: LiveData<String> get() = _number2

    private val _storageValue = MutableLiveData(0.0)
    val storageValue: LiveData<Double> get() = _storageValue

    private val _memory = MutableLiveData(0.0)
    val memory: LiveData<Double> get() = _memory

    private val _textToDisplay = MutableLiveData<String>("")
    val textToDisplay: LiveData<String> get() = _textToDisplay


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

        when (operation) {
            "+" -> {
                if (_number1.value!!.isNotEmpty()) {
                    _storageValue.value = _storageValue.value!! + _number1.value!!.toDouble()
                    _number1.value = ""
                    _textToDisplay.value += "+"
                } else {
                    _storageValue.value = _storageValue.value!! + _memory.value!!
                    _number1.value = ""
                    _textToDisplay.value += "+"
                }
            }

            "-" -> {
                if (_number1.value!!.isNotEmpty()) {
                    _storageValue.value = _storageValue.value!! - _number1.value!!.toDouble()
                    _number1.value = ""
                    _textToDisplay.value += "-"
                } else {
                    _storageValue.value = _storageValue.value!! - _memory.value!!
                    _number1.value = ""
                    _textToDisplay.value += "-"
                }
            }

            "X" -> {
                if (_number1.value!!.isNotEmpty()) {
                    _storageValue.value = _number1.value!!.toDouble()
                    _number1.value = ""
                    _textToDisplay.value += "X"
                } else {
                    _storageValue.value = _storageValue.value!! * _memory.value!!
                    _number1.value = ""
                    _textToDisplay.value += "X"
                }
            }

            "÷" -> {
                if (_number1.value!!.isNotEmpty()) {
                    _storageValue.value = _storageValue.value!! / _number1.value!!.toDouble()
                    _number1.value = ""
                    _textToDisplay.value += "÷"
                } else {
                    _storageValue.value = _storageValue.value!! / _memory.value!!
                    _number1.value = ""
                    _textToDisplay.value += "÷"
                }
            }
        }
    }

    fun result() {
        val result = _number1.value!!.toDouble()*_storageValue.value!!
        _memory.value = result
        _textToDisplay.value = result.toString()
    }
}
