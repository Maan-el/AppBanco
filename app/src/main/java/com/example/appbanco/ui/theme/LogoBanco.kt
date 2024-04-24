package com.example.appbanco.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.appbanco.R

@Composable
fun LogoBanco(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.punpun),
        contentDescription = "Logo do banco",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}