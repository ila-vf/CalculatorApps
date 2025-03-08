package com.example.calculatorapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapps.ui.theme.CalculatorAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Kalkulator Sederhana", fontSize = 24.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Angka Pertama") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Angka Kedua") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Button(onClick = { result = calculate(number1, number2, "+") }) { Text("+") }
            Button(onClick = { result = calculate(number1, number2, "-") }) { Text("-") }
            Button(onClick = { result = calculate(number1, number2, "*") }) { Text("×") }
            Button(onClick = { result = calculate(number1, number2, "/") }) { Text("÷") }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB))
        ) {
            Text(
                text = "Hasil: $result",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

fun calculate(num1: String, num2: String, operator: String): String {
    val n1 = num1.toFloatOrNull()
    val n2 = num2.toFloatOrNull()
    if (n1 == null || n2 == null) return "Input tidak valid"

    return when (operator) {
        "+" -> (n1 + n2).toString()
        "-" -> (n1 - n2).toString()
        "*" -> (n1 * n2).toString()
        "/" -> if (n2 != 0f) (n1 / n2).toString() else "Tidak bisa bagi 0"
        else -> "Operator tidak valid"
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    CalculatorAppsTheme {
        CalculatorApp()
    }
}

//Ila Virnanda Fitriana / 225150701111011 / Pengembangan Aplikasi Mobile Lanjut