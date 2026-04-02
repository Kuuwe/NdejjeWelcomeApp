package com.example.welcomeapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.welcomeapp.ui.theme.NdejjeWelcomeAppTheme
import com.example.welcomeapp.ui.theme.PresentGreen

/**
 * A tiny composable with a single job:
 * show "Verified" in green or "Not Verified" in red.
 *
 * Extracting this means if the university later wants to
 * add a badge icon or change the wording, there is exactly
 * ONE place to edit.
 */
@Composable
fun VerificationBadge(isVerified: Boolean) {
    if (isVerified) {
        Text(
            text       = "✓ Verified",
            fontSize   = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color      = PresentGreen           // from our Color.kt
        )
    } else {
        Text(
            text       = "✗ Not Verified",
            fontSize   = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color      = MaterialTheme.colorScheme.error  // from theme
        )
    }
}

@Preview(showBackground = true, name = "Verified")
@Composable
private fun VerifiedPreview() {
    NdejjeWelcomeAppTheme { VerificationBadge(isVerified = true) }
}

@Preview(showBackground = true, name = "Not verified")
@Composable
private fun NotVerifiedPreview() {
    NdejjeWelcomeAppTheme { VerificationBadge(isVerified = false) }
}