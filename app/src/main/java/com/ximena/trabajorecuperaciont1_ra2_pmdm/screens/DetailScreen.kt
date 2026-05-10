package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.TaskRepository

// pantalla de detalle que muestra toda la informacion de una tarea
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {

    val task = TaskRepository.selectedTask

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de tarea") },
                navigationIcon = {
                    // boton para volver a la pantalla anterior
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // titulo de la tarea, tachado si esta completada
            Text(
                text = task?.title ?: "",
                style = MaterialTheme.typography.titleLarge,
                textDecoration = if (task?.isCompleted == true)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
            )

            // descripcion de la tarea
            Text(
                text = task?.description ?: "",
                style = MaterialTheme.typography.bodyLarge
            )

            // etiqueta que muestra el estado de la tarea
            Text(
                text = if (task?.isCompleted == true) "Estado: Completada" else "Estado: Pendiente",
                style = MaterialTheme.typography.bodyMedium,
                color = if (task?.isCompleted == true)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}