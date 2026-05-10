package com.ximena.trabajorecuperaciont1_ra2_pmdm.data

import androidx.compose.runtime.mutableStateListOf
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Task

// repositorio que guarda las tareas en memoria
// mutableStateListOf hace que la lista sea reactiva,
// es decir que la UI se actualiza sola cuando cambia
object TaskRepository {
    val tasks = mutableStateListOf<Task>()
    var selectedTask: Task? = null
}