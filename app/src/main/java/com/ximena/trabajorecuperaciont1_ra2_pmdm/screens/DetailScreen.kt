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
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.GreenPastel
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.RedPastel

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

            // etiqueta de estado con fondo de color segun si esta completada o pendiente
            Surface(
                shape = MaterialTheme.shapes.small,
                color = if (task?.isCompleted == true) GreenPastel else RedPastel
            ) {
                Text(
                    text = if (task?.isCompleted == true) "Completada" else "Pendiente",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }
        }
    }
}