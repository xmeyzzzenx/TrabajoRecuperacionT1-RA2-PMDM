package com.ximena.trabajorecuperaciont1_ra2_pmdm.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Note

@Composable
fun NoteCard(note: Note) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = note.title)
            Text(text = note.description)
        }
    }
}