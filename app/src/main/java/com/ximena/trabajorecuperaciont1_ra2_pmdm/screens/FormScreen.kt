package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.NoteRepository
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Note

@Composable
fun FormScreen(navController: NavController) {

    val existingNote = NoteRepository.selectedNote

    var title by remember { mutableStateOf(existingNote?.title ?: "") }
    var description by remember { mutableStateOf(existingNote?.description ?: "") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = if (existingNote != null) "Editar nota" else "Nueva nota",
                style = MaterialTheme.typography.titleLarge
            )

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    keyboardController?.hide()

                    if (title.isBlank() || description.isBlank()) {
                        scope.launch {
                            snackbarHostState.showSnackbar("Completa todos los campos")
                        }
                    } else {

                        if (existingNote != null) {
                            val index = NoteRepository.notes.indexOf(existingNote)
                            if (index != -1) {
                                NoteRepository.notes[index] = Note(title, description)
                            }
                        } else {
                            NoteRepository.notes.add(
                                Note(title, description)
                            )
                        }

                        NoteRepository.selectedNote = null

                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (existingNote != null) "Actualizar" else "Guardar")
            }
        }
    }
}