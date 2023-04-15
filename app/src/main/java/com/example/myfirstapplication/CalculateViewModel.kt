package com.example.myfirstapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {
    var num1 by mutableStateOf("")
    var num2 by mutableStateOf("")
    var answer by mutableStateOf("")

    fun onNum1Change(newString: String) {
        num1 = newString
    }

    fun onNum2Change(newString: String) {
        num2 = newString
    }


    fun onAnswerChange(newString: String) {
    answer = newString
    }

    fun calculate() {
        val result = (num1.toIntOrNull() ?: 0) + (num2.toIntOrNull() ?: 0)
        answer = result.toString()
    }
}