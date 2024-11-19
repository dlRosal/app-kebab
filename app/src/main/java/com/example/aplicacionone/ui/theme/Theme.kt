package com.example.aplicacionone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Colores predeterminados de Material Design para el modo claro
private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Background,
    surface = Surface,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary,
    onBackground = OnBackground,
    onSurface = OnSurface
)

// Colores predeterminados de Material Design para el modo oscuro
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Color Scheme para el tema Kebab
val KebabColorScheme = lightColorScheme(
    primary = KebabPrimary,
    secondary = KebabSecondary,
    background = KebabBackground,
    surface = KebabSurface,
    onPrimary = KebabOnPrimary,
    onSecondary = KebabOnSecondary,
    onBackground = KebabOnBackground,
    onSurface = KebabOnSurface
)

@Composable
fun AplicacionOneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    kebabTheme: Boolean = false, // Nuevo parámetro para el Modo Kebab
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        kebabTheme -> KebabColorScheme
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = if (kebabTheme) KebabTypography else Typography, // Usar tipografía predeterminada
        content = content
    )
}
