package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

class MainActivity : ComponentActivity() {
    val calculateViewModel by viewModels<CalculateViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyFirstApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                   Calculate(calculateViewModel = calculateViewModel)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
    fun Calculate( calculateViewModel: CalculateViewModel ) {
//        var num1 by remember { mutableStateOf("") }
//        var num2 by remember { mutableStateOf("") }
//        var answer  by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {

            Text(text = "Sum = " + calculateViewModel.answer)

            TextField(label = "First Number", value = calculateViewModel.num1, onValueChange = { newValue -> calculateViewModel.num1 = newValue })

            Spacer(modifier = Modifier.height(10.dp))

            TextField(label = "Second Number", value = calculateViewModel.num2, onValueChange = { newValue -> calculateViewModel.num2 = newValue })

            Button(
                onClick = {
//                    var result = (num1.toIntOrNull() ?: 0) + (num1.toIntOrNull() ?: 0)
//                    answer = result.toInt()
                          calculateViewModel.calculate()
                },
                enabled = calculateViewModel.num1.isNotBlank() && calculateViewModel.num2.isNotBlank()
            ) {
                Text(text = "Add")
            }


            
        }
    }

@Composable
fun TextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    var num by remember { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label)},
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )

}




