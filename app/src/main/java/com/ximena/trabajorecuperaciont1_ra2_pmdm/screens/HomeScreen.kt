package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import com.ximena.trabajorecuperaciont1_ra2_pmdm.components.TaskCard
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.TaskRepository

// pantalla principal con la lista de tareas
@Composable
fun HomeScreen(navController: NavController) {

    val tasks = TaskRepository.tasks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Mis tareas",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (tasks.isEmpty()) {

            // si no hay tareas mostramos un icono y un mensaje centrado en la pantalla
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "No hay tareas todavia",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

        } else {

            // lista con scroll que muestra todas las tareas
            // contentPadding evita que el FAB tape la ultima tarea
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(tasks) { task ->

                    TaskCard(
                        task = task,
                        navController = navController,
                        onDelete = { TaskRepository.tasks.remove(task) },
                        onEdit = {
                            TaskRepository.selectedTask = task
                            navController.navigate("form")
                        },
                        // invertimos el estado actual de la tarea
                        onToggleComplete = {
                            val index = TaskRepository.tasks.indexOf(task)
                            if (index != -1) {
                                TaskRepository.tasks[index] = task.copy(
                                    isCompleted = !task.isCompleted
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}