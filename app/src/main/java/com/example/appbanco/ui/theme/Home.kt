package com.example.appbanco.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appbanco.R
import com.example.appbanco.ui.theme.ui.theme.AppBancoTheme
import java.text.NumberFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = { TopInfo() },
//                modifier = Modifier.padding(2.dp)
            )
        }
    ) { paddingValues ->
        Dinheiro(Modifier.padding(paddingValues))
    }

}

@Composable
fun TopInfo(usuario: String = "usuário") {
    Row(modifier = Modifier.padding(2.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.death_grips_exmilitary),
            contentDescription = "Temporary user icon",
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = "Bem Vindo",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 2.dp)
            )
            Text(text = usuario, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun Dinheiro(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Saldo()
        Movimentacoes()
    }
}

@Composable
private fun Saldo() {
    val format = NumberFormat.getCurrencyInstance()

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 30.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = "Saldo",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
        )
        Text(
            text = format.format(12_000f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 1.dp)
        )
    }
}

@Composable
fun Movimentacoes(
    tipoMovimento: List<String> = List(1000) { if (it.mod(2) == 0) "Entrada" else "Saida" },
    value: List<Float> = List(1000) { it.toFloat() }
) {
    assert(tipoMovimento.size == value.size)
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
    ) {
        LazyColumn() {
            itemsIndexed(tipoMovimento) { i, _ ->
                Movimentacao(tipoMovimento = tipoMovimento[i], value = value[i])
            }
        }
    }
}

@Composable
fun Movimentacao(tipoMovimento: String, value: Float) {
    val format = NumberFormat.getCurrencyInstance()

    Text(
        text = tipoMovimento,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
    )
    Text(
        text = format.format(value),
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun BarPreview() {
    AppBancoTheme {
        TopBar()
    }
}