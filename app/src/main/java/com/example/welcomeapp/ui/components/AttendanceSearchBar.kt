package com.example.welcomeapp.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.welcomeapp.ui.theme.NdejjeWelcomeAppTheme

@Composable
fun AttendanceSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value         = query,
        onValueChange = onQueryChange,
        placeholder   = {
            Text(
                text  = "Search by name or reg number…",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        leadingIcon   = {
            Icon(
                imageVector        = Icons.Default.Search,
                contentDescription = "Search icon",
                tint               = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        trailingIcon  = if (query.isNotEmpty()) {
            {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(
                        imageVector        = Icons.Default.Close,
                        contentDescription = "Clear search",
                        tint               = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else null,
        modifier      = modifier,
        shape         = RoundedCornerShape(50.dp),
        singleLine    = true,
        colors        = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedBorderColor   = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true, name = "Empty")
@Composable
private fun SearchBarEmptyPreview() {
    NdejjeWelcomeAppTheme {
        AttendanceSearchBar(query = "", onQueryChange = {})
    }
}

@Preview(showBackground = true, name = "With text")
@Composable
private fun SearchBarFilledPreview() {
    NdejjeWelcomeAppTheme {
        AttendanceSearchBar(query = "Akello", onQueryChange = {})
    }
}