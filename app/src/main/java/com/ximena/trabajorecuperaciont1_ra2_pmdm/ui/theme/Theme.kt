package com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// esquema de colores de la app
// asigna cada color definido en Color.kt a su rol dentro de Material Design 3
private val LightColorScheme = lightColorScheme(
    primary = Primary,                    // negro para botones principales
    secondary = Secondary,                // gris claro para superficies
    background = Background,              // fondo blanco
    surface = Surface,                    // superficie blanca
    secondaryContainer = GrayMedium,      // gris para el indicador de la bottom bar
    onSecondaryContainer = OnSurface,     // texto negro sobre gris
    onPrimary = OnPrimary,                // texto blanco sobre negro
    onSecondary = OnSurface,              // texto negro sobre gris claro
    onBackground = OnSurface,             // texto negro sobre fondo blanco
    onSurface = OnSurface,                // texto negro sobre superficie blanca
    surfaceVariant = GrayLight,           // gris claro para el drawer
    onSurfaceVariant = GrayDark,          // texto gris para informacion secundaria
    error = Color(0xFFB00020)             // rojo para errores del formulario
)

// tema principal de la app
// aplica los colores y la tipografia al contenido
@Composable
fun TrabajoRecuperacionT1RA2PMDMTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}