package com.ximena.trabajorecuperaciont1_ra2_pmdm.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.navigation.NavController
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Task
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.TaskRepository
import com.ximena.trabajorecuperaciont1_ra2_pmdm.ui.theme.RedStrike

// tarjeta que muestra una tarea en la lista
// recibe la tarea, el navController y las acciones de borrar, editar y completar
@Composable
fun TaskCard(
    task: Task,
    navController: NavController,
    onDelete: () -> Unit,
    onEdit: () -> Unit,
    onToggleComplete: () -> Unit
) {

    // usamos OutlinedCard para que tenga borde y se distinga del fondo blanco
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)),
        colors = CardDefaults.cardColors(
            // la card siempre es gris claro, el estado se ve en el tachado
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // fila superior con el titulo y la X para eliminar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    // si esta completada tachamos el titulo en rojo
                    textDecoration = if (task.isCompleted)
                        TextDecoration.LineThrough
                    else
                        TextDecoration.None,
                    color = if (task.isCompleted)
                        RedStrike
                    else
                        MaterialTheme.colorScheme.onSurface
                )

                // boton X para eliminar la tarea
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Eliminar tarea",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // si esta completada tachamos la descripcion en rojo
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textDecoration = if (task.isCompleted)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None,
                color = if (task.isCompleted)
                    RedStrike
                else
                    MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // boton para ver el detalle de la tarea
                OutlinedButton(
                    onClick = {
                        TaskRepository.selectedTask = task
                        navController.navigate("detail")
                    },
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSurface),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text("Ver")
                }

                // boton para editar la tarea
                OutlinedButton(
                    onClick = onEdit,
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSurface),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text("Editar")
                }

                // textbutton para alternar entre completada y pendiente
                TextButton(
                    onClick = onToggleComplete,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text("Completar/Pendiente")
                }
            }
        }
    }
}