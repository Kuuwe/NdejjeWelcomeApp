package com.example.welcomeapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.welcomeapp.ui.theme.NdejjeWelcomeAppTheme
import com.example.welcomeapp.ui.theme.PresentGreen

/**
 * Displays the live count of filtered students and how many
 * are marked present.
 *
 * Completely stateless — just receives two integers.
 * Because it is so simple, it is very easy to test and preview.
 */
@Composable
fun AttendanceSummary(
    filteredCount: Int,
    presentCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier            = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text  = "$filteredCount student(s) shown",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            // Green when anyone is present, muted otherwise
            text  = "$presentCount present",
            style = MaterialTheme.typography.labelMedium,
            color = if (presentCount > 0) PresentGreen
            else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true, name = "Nobody present")
@Composable
private fun SummaryEmptyPreview() {
    NdejjeWelcomeAppTheme {
        AttendanceSummary(filteredCount = 10, presentCount = 0)
    }
}

@Preview(showBackground = true, name = "Some present")
@Composable
private fun SummarySomePreview() {
    NdejjeWelcomeAppTheme {
        AttendanceSummary(filteredCount = 10, presentCount = 4)
    }
}