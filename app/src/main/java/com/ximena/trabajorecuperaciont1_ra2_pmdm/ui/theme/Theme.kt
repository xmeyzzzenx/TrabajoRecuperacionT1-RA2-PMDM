package com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,

    background = Background,
    surface = Surface,

    secondaryContainer = Primary,
    onSecondaryContainer = OnPrimary,

    onPrimary = OnPrimary,
    onSecondary = OnPrimary,
    onBackground = OnSurface,
    onSurface = OnSurface
)

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