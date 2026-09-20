package com.example.damcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.damcompose.ui.theme.DAMComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DAMComposeTheme {
                Contador()
            }
        }
    }
}

@Composable
fun Contador() {

    var contador by remember {
        mutableStateOf(0)
    }

    //si detecta que cambia el efecto lo vuelve a lanzar
    // aunque no haya terminado la ejecucion anterior, con
    // unit es una clave que nunca cambia
    LaunchedEffect(contador) {

        println("EMPIEZA efecto con contador = $contador")

        delay(5000)

        println("TERMINA efecto con contador = $contador")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Contador: $contador"
        )

        Button(
            onClick = {
                contador++
            }
        ) {
            Text("Incrementar")
        }
    }
}