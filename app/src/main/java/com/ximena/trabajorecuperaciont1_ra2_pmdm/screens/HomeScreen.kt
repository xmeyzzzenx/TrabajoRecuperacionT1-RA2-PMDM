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
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Note

@Composable
fun HomeScreen(navController: NavController) {

    val notes = listOf(
        Note("Proyecto final", "Seguir avanzando la app"),
        Note("Recuperación PMDM","Ir terminando la app"),
        Note("Recuperación PSP","Repasar hilos y corrutinas")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        Text(
            text = "Mis notas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(notes) { note ->
                NoteCard(note)
            }
        }
    }
}