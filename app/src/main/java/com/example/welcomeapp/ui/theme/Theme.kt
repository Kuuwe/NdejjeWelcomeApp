package com.example.welcomeapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color          // ← THIS fixes Color.White
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat             // ← THIS fixes WindowCompat

private val LightColors = lightColorScheme(
    primary   = NdejjeBlue,
    onPrimary = Color.White,       // now resolved ✓
    secondary = NdejjeGold,
    error     = AbsentRed,
    surface   = SurfaceLight,
)

private val DarkColors = darkColorScheme(
    primary   = NdejjeLightBlue,
    onPrimary = Color.White,       // now resolved ✓
    secondary = NdejjeGold,
    error     = AbsentRed,
    surface   = SurfaceDark,
)

@Composable
fun NdejjeWelcomeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content     = content
    )
}