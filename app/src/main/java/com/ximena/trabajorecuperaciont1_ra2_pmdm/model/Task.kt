package com.ximena.trabajorecuperaciont1_ra2_pmdm.model

// modelo de datos de una tarea
// title: titulo de la tarea
// description: descripcion de la tarea
// isCompleted: si la tarea esta completada o no, por defecto es false
data class Task(
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)