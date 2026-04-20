package com.ximena.trabajorecuperaciont1_ra2_pmdm.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Note

@Composable
fun NoteCard(
    note: Note,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(text = note.title)

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = note.description)

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    Alignment.CenterHorizontally
                )
            ) {

                Button(onClick = onEdit) {
                    Text("Editar")
                }

                Button(onClick = onDelete) {
                    Text("Eliminar")
                }
            }
        }
    }
}