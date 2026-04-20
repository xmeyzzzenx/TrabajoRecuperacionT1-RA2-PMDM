package com.ximena.trabajorecuperaciont1_ra2_pmdm.data

import androidx.compose.runtime.mutableStateListOf
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Note

object NoteRepository {
    val notes = mutableStateListOf<Note>()
    var selectedNote: Note? = null

}