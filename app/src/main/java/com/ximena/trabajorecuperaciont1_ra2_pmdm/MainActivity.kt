package com.ximena.trabajorecuperaciont1_ra2_pmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation.NavGraph
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.TrabajoRecuperacionT1RA2PMDMTheme

// actividad principal, punto de entrada de la app
// aqui aplicamos el tema y lanzamos la navegacion
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrabajoRecuperacionT1RA2PMDMTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph()
                }
            }
        }
    }
}