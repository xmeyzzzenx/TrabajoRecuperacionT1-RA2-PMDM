package com.ximena.trabajorecuperaciont1_ra2_pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation.NavGraph
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.TrabajoRecuperacionT1RA2PMDMTheme

// punto de entrada de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ocupa toda la pantalla incluyendo la barra de estado
        enableEdgeToEdge()
        setContent {
            // aplicamos el tema de la app al contenido
            TrabajoRecuperacionT1RA2PMDMTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    // lanzamos la navegacion principal
                    NavGraph()
                }
            }
        }
    }
}