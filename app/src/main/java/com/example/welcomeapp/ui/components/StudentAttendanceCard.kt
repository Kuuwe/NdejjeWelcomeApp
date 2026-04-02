package com.example.welcomeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.welcomeapp.R
import com.example.welcomeapp.model.Student
import com.example.welcomeapp.ui.theme.*

/**
 * Displays one student's attendance card.
 *
 * STATELESS — owns no state.
 * Receives isPresent from AttendanceScreen (the state owner).
 * Reports button clicks upward via onMarkPresent.
 *
 * The card background changes colour when the student is
 * marked present — driven entirely by the isPresent parameter.
 */
@Composable
fun StudentAttendanceCard(
    student: Student,
    isPresent: Boolean,
    onMarkPresent: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape    = RoundedCornerShape(16.dp),
        colors   = CardDefaults.elevatedCardColors(
            containerColor = if (isPresent) PresentCardTint
            else MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier            = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ── Profile photo ─────────────────────────────────
            // Green ring around photo when present — visual feedback
            val ringColor = if (isPresent) PresentButtonGreen else Color.Transparent
            Image(
                painter            = painterResource(student.photoRes),
                contentDescription = "Photo of ${student.name}",
                contentScale       = ContentScale.Crop,
                modifier           = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(3.dp, ringColor, CircleShape)  // NEW: status ring
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ── Name ──────────────────────────────────────────
            Text(
                text       = student.name,
                style      = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color      = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(2.dp))

            // ── Reg number ────────────────────────────────────
            Text(
                text  = student.regNo,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // ── Programme + year ──────────────────────────────
            Text(
                text  = "${student.programme}  ·  Year ${student.yearOfStudy}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ── Verification badge (extracted composable) ─────
            VerificationBadge(isVerified = student.isVerified)

            Spacer(modifier = Modifier.height(12.dp))

            // ── Attendance button ─────────────────────────────
            Button(
                onClick  = onMarkPresent,
                enabled  = !isPresent,          // disabled once marked
                shape    = RoundedCornerShape(50.dp),
                colors   = ButtonDefaults.buttonColors(
                    containerColor         = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = PresentButtonGreen,  // stays green, not grey
                    disabledContentColor   = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.65f)
            ) {
                Text(
                    text       = if (isPresent) "✓ Present" else "Mark Present",
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

// ── Previews ─────────────────────────────────────────────────
// Use real data so long names don't break the layout silently

private val sampleStudent = Student(
    id          = 1,
    name        = "Akello Stellamaris",
    regNo       = "24/2/314/01",
    programme   = "BIT",
    photoRes    = R.drawable.emma,
    yearOfStudy = 2,
    isVerified  = true
)

@Preview(showBackground = true, name = "Not yet marked")
@Composable
private fun CardNotMarkedPreview() {
    NdejjeWelcomeAppTheme {
        StudentAttendanceCard(
            student      = sampleStudent,
            isPresent    = false,
            onMarkPresent = {}
        )
    }
}

@Preview(showBackground = true, name = "Marked present")
@Composable
private fun CardMarkedPreview() {
    NdejjeWelcomeAppTheme {
        StudentAttendanceCard(
            student      = sampleStudent,
            isPresent    = true,
            onMarkPresent = {}
        )
    }
}