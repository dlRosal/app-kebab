package com.example.aplicacionone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.aplicacionone.R

val miFuente = FontFamily(
    Font(R.font.letra)
)

// Tipografía predeterminada de Material Design
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    displayLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )
)

// Tipografía para el Modo Kebab (personalización del tema kebab)
val KebabTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = miFuente,
        fontSize = 32.sp,
        color = KebabPrimary // Cambiar al color rojo del tema kebab
    ),
    headlineMedium = TextStyle(
        fontFamily = miFuente,
        fontSize = 24.sp,
        color = KebabSecondary // Cambiar al color amarillo del tema kebab
    ),
    bodyLarge = TextStyle(
        fontFamily = miFuente,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = OnSecondary // Cambiar al color verde del tema kebab
    )
)
