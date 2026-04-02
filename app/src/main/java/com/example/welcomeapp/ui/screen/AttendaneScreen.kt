package com.example.welcomeapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.welcomeapp.data.StudentDataProvider
import com.example.welcomeapp.ui.components.*
import com.example.welcomeapp.ui.theme.NdejjeWelcomeAppTheme

/**
 * AttendanceScreen is the STATE OWNER for this feature.
 *
 * It is the "dispatcher" from the bodaboda analogy in Module 4:
 * it holds all the information and passes pieces down to
 * stateless child composables.
 *
 * State owned here:
 *   searchQuery  — what the user has typed in the search bar
 *   presentIds   — which student IDs have been marked present
 *
 * Nothing else owns state. All children are stateless.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen() {

    // ── State ─────────────────────────────────────────────────
    var searchQuery by remember { mutableStateOf("") }
    var presentIds  by remember { mutableStateOf(setOf<Int>()) }

    val allStudents = StudentDataProvider.students

    /**
     * derivedStateOf: recomputes only when searchQuery changes
     * AND only triggers recomposition when the RESULT changes.
     * More efficient than remember(searchQuery) { filter() }
     * because if the user types and deletes back to the same
     * text, the list doesn't needlessly redraw.
     */
    val filteredStudents by remember {
        derivedStateOf {
            if (searchQuery.isBlank()) allStudents
            else allStudents.filter {
                it.name.contains(searchQuery, ignoreCase = true) ||
                        it.regNo.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    // ── Layout ────────────────────────────────────────────────
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text  = "Ndejje Attendance",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text  = "BIT 2205 — Semester II 2025/2026",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)   // respects the TopAppBar height
        ) {

            // Search bar (stateless, state hoisted here)
            AttendanceSearchBar(
                query         = searchQuery,
                onQueryChange = { searchQuery = it },
                modifier      = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )

            // Live count summary
            AttendanceSummary(
                filteredCount = filteredStudents.size,
                presentCount  = presentIds.size
            )

            // ── List or empty state ───────────────────────────
            if (filteredStudents.isEmpty()) {
                // Empty state — shown when search finds nothing
                Box(
                    modifier          = Modifier.fillMaxSize(),
                    contentAlignment  = Alignment.Center
                ) {
                    Text(
                        text  = "No student found for \"$searchQuery\"",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier        = Modifier.fillMaxSize(),
                    contentPadding  = PaddingValues(
                        start  = 16.dp,
                        end    = 16.dp,
                        top    = 8.dp,
                        bottom = 24.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = filteredStudents,
                        key   = { it.id }   // stable key — prevents wrong-card redraws
                    ) { student ->

                        val isPresent = student.id in presentIds

                        StudentAttendanceCard(
                            student       = student,
                            isPresent     = isPresent,
                            onMarkPresent = {
                                // + creates a NEW Set — required to trigger recomposition
                                presentIds = presentIds + student.id
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AttendanceScreenPreview() {
    NdejjeWelcomeAppTheme {
        AttendanceScreen()
    }
}