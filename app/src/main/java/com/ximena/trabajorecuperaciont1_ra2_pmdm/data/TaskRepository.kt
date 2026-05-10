package com.ximena.trabajorecuperaciont1_ra2_pmdm.data

import androidx.compose.runtime.mutableStateListOf
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Task

object NoteRepository {
    val notes = mutableStateListOf<Task>()
    var selectedNote: Task? = null

}