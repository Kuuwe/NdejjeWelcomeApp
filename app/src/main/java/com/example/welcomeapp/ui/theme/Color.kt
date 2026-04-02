package com.example.welcomeapp.ui.theme

import androidx.compose.ui.graphics.Color

// ── Ndejje brand colours ──────────────────────────────────────
val NdejjeBlue       = Color(0xFF1A237E)   // deep university blue
val NdejjeLightBlue  = Color(0xFF1565C0)   // slightly lighter for buttons
val NdejjeGold       = Color(0xFFFFC107)   // accent / highlights

// ── Attendance status colours ────────────────────────────────
// Named constants mean you change the colour in ONE place,
// and every composable that references it updates automatically.
val PresentGreen        = Color(0xFF2E7D32)   // dark green — "Verified" text
val PresentCardTint     = Color(0xFFF1F8E9)   // very light green — card background
val PresentButtonGreen  = Color(0xFF4CAF50)   // medium green — "✓ Present" button
val AbsentRed           = Color(0xFFB71C1C)   // deep red — "Not Verified" text

// ── Neutral / surface colours ─────────────────────────────────
val SurfaceLight     = Color(0xFFFAFAFA)
val SurfaceDark      = Color(0xFF121212)