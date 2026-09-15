package com.example.damcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.damcompose.ui.theme.DAMComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAMComposeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(   //import con alt + enter
        modifier = modifier
    ) {
        Text(
            text = "Mi primera app en compose"
            //modifier = modifier
        )
        Text("desarrollo de interfaces")
        Text("kotlin + jetpack compose")

        Row{
            Text("Kotlin"
            //, Modifier.padding(end = 16.dp)
                //o ros(horizontalArrangement = Arrangement.spacedBy(16.dp) "quiero que haya 16 dp entre los elementos de este row
                     )
            Text("Compose")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DAMComposeTheme {
        Greeting()
    }
}