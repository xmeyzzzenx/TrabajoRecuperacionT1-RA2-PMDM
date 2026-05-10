package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.TaskRepository
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.RedStrike

// pantalla de detalle con toda la informacion de una tarea
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {

    val task = TaskRepository.selectedTask

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de tarea") },
                navigationIcon = {
                    // flecha para volver a la pantalla anterior
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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

            // titulo tachado en rojo vino si la tarea esta completada
            Text(
                text = task?.title ?: "",
                style = MaterialTheme.typography.titleLarge,
                textDecoration = if (task?.isCompleted == true)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None,
                color = if (task?.isCompleted == true)
                    RedStrike
                else
                    MaterialTheme.colorScheme.onSurface
            )

            // separador visual entre titulo y descripcion
            HorizontalDivider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))

            // descripcion tachada en rojo vino si la tarea esta completada
            Text(
                text = task?.description ?: "",
                style = MaterialTheme.typography.bodyLarge,
                textDecoration = if (task?.isCompleted == true)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None,
                color = if (task?.isCompleted == true)
                    RedStrike
                else
                    MaterialTheme.colorScheme.onSurface
            )

            // etiqueta con el estado de la tarea, cambia de color segun si esta completada o no
            Surface(
                shape = MaterialTheme.shapes.small,
                color = if (task?.isCompleted == true)
                    MaterialTheme.colorScheme.surfaceVariant
                else
                    MaterialTheme.colorScheme.secondary
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