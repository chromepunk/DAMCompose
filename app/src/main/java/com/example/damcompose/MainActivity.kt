package com.example.damcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.damcompose.ui.theme.DAMComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DAMComposeTheme {
                Semaforo()
            }
        }
    }
}

@Composable
fun Semaforo() {

    var estado by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(Unit) {

        while (true) {

            delay(2000)

            estado++

            if (estado == 3) {
                estado = 0
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Semáforo"
        )

        Luz(
            color = Color.Red,
            encendida = estado == 0
        )

        Luz(
            color = Color.Yellow,
            encendida = estado == 1
        )

        Luz(
            color = Color.Green,
            encendida = estado == 2
        )
    }
}

@Composable
fun Luz(
    color: Color,
    encendida: Boolean
) {

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(
                if (encendida) color else Color.DarkGray,
                CircleShape
            )
    )
}