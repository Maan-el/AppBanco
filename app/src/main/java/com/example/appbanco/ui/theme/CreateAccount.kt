package com.example.appbanco.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.appbanco.ui.theme.ui.theme.AppBancoTheme

class CreateAccount : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppBancoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateUserAccount()
                }
            }
        }
    }
}

@Composable
fun CreateUserAccount() {
    Column(Modifier.padding(20.dp)) {
        var nome by remember { mutableStateOf("") }
        var senha by remember { mutableStateOf("") }
        var senhaConfirmar by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var dataNascimento by remember { mutableStateOf("") }

        LogoBanco(Modifier.padding(20.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it.trim() },
            label = {
                Text(
                    text = "Nome completo",
                    color = MaterialTheme.colorScheme.primary,
                    style = Typography.titleMedium,
                )
            },
        )
        OutlinedTextField(
            value = dataNascimento,
            onValueChange = { dataNascimento = it.trim() },
            label = {
                Text(
                    text = "Data de Nascimento",
                    color = MaterialTheme.colorScheme.primary,
                    style = Typography.titleMedium
                )
            },
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it.trim() },
            label = {
                Text(
                    text = "E-mail",
                    color = MaterialTheme.colorScheme.primary,
                    style = Typography.titleMedium
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it.trim() },
            label = {
                Text(
                    text = "Senha",
                    color = MaterialTheme.colorScheme.primary,
                    style = Typography.titleMedium
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        val isNotMatching = remember {
            derivedStateOf {
                senha != senhaConfirmar
            }
        }
        OutlinedTextField(
            value = senhaConfirmar,
            onValueChange = { senhaConfirmar = it.trim() },
            label = {
                Text(
                    text = "Senha",
                    color = MaterialTheme.colorScheme.primary,
                    style = Typography.titleMedium
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = isNotMatching.value
        )
        ElevatedButton(onClick = { /*TODO*/ }, enabled = !isNotMatching.value) {}
    }
}
