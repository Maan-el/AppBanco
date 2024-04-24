package com.example.appbanco.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Login() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LogoBanco(
            Modifier
                .clip(CircleShape)
                .size(150.dp)
        )
        Text(
            text = "Login",
            modifier = Modifier.padding(30.dp),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleLarge
        )

        UserForms()

        UserButtons()
    }
}

@Composable
private fun UserButtons() {
    ElevatedButton(
        onClick = { /*TODO*/ }, modifier = Modifier
            .padding(30.dp)
            .width(150.dp)
    ) {
        Text(
            text = "Entrar",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )
    }
    ElevatedButton(
        onClick = { },
        modifier = Modifier.width(150.dp)
    ) {
        Text(
            text = "Criar conta",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun UserForms() {
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    OutlinedTextField(
        value = login,
        onValueChange = { login = it },
        label = {
            Text(
                text = "Usuário",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
        },
        modifier = Modifier.padding(10.dp),
        singleLine = true
    )
    OutlinedTextField(
        value = senha,
        onValueChange = { senha = it },
        label = {
            Text(
                text = "Senha",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true
    )
}