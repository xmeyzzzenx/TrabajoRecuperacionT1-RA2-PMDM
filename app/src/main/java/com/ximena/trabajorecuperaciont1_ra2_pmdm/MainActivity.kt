package com.ximena.trabajorecuperaciont1_ra2_pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.TrabajoRecuperacionT1RA2PMDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrabajoRecuperacionT1RA2PMDMTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Text(text = "Hola")
}