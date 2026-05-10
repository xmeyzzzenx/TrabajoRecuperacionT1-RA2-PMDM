package com.ximena.trabajorecuperaciont1_ra2_pmdm.model

// clase que representa una tarea con titulo, descripcion
// y un estado para saber si esta completada o no
data class Task(
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)