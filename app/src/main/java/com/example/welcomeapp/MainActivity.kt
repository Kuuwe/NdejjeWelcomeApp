package com.example.welcomeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.welcomeapp.ui.screen.AttendanceScreen
import com.example.welcomeapp.ui.theme.NdejjeWelcomeAppTheme

/**
 * MainActivity is now just a launcher.
 * It does ONE thing: apply the theme and open AttendanceScreen.
 *
 * All UI logic lives in the screen and component files.
 * If you add a second screen later, you add navigation here —
 * you don't touch AttendanceScreen at all.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NdejjeWelcomeAppTheme {
                AttendanceScreen()
            }
        }
    }
}