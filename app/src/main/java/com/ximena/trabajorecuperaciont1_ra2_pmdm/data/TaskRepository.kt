package com.ximena.trabajorecuperaciont1_ra2_pmdm.data

import androidx.compose.runtime.mutableStateListOf
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Task

// almacena las tareas en memoria mientras la app esta abierta
// mutableStateListOf hace que la UI se actualice sola cuando cambia la lista
object TaskRepository {
    val tasks = mutableStateListOf<Task>()  // lista de todas las tareas
    var selectedTask: Task? = null          // tarea seleccionada para ver o editar
}