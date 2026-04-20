package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.components.NoteCard
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.NoteRepository

@Composable
fun HomeScreen(navController: NavController) {

    val notes = NoteRepository.notes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Mis notas",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (notes.isEmpty()) {
            Text("No hay notas todavía")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(notes) { note ->

                    NoteCard(
                        note = note,

                        onDelete = {
                            NoteRepository.notes.remove(note)
                        },

                        onEdit = {
                            NoteRepository.selectedNote = note
                            navController.navigate("form")
                        }
                    )
                }
            }
        }
    }
}