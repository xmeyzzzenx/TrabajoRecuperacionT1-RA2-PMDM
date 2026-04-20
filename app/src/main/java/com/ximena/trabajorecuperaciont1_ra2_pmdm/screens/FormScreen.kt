package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.NoteRepository
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Note

@Composable
fun FormScreen(navController: NavController) {

    val existingNote = NoteRepository.selectedNote

    var title by remember { mutableStateOf(existingNote?.title ?: "") }
    var description by remember { mutableStateOf(existingNote?.description ?: "") }

    var titleError by remember { mutableStateOf(false) }
    var descriptionError by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState) { data ->
                Snackbar(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(0.9f),
                    shape = MaterialTheme.shapes.medium,
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onError
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Error"
                        )
                        Text(data.visuals.message)
                    }
                }
            }
        }
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
                onValueChange = {
                    title = it
                    titleError = it.isBlank()
                },
                label = { Text("Título") },
                singleLine = true,
                isError = titleError,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                    descriptionError = it.isBlank()
                },
                label = { Text("Descripción") },
                isError = descriptionError,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    keyboardController?.hide()

                    titleError = title.isBlank()
                    descriptionError = description.isBlank()

                    if (titleError || descriptionError) {
                        scope.launch {
                            snackbarHostState.showSnackbar("Completa todos los campos")
                        }
                        return@Button
                    }

                    val newNote = Note(title, description)

                    if (existingNote != null) {
                        val index = NoteRepository.notes.indexOf(existingNote)
                        if (index != -1) {
                            NoteRepository.notes[index] = newNote
                        }
                    } else {
                        NoteRepository.notes.add(newNote)
                    }

                    NoteRepository.selectedNote = null

                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text(if (existingNote != null) "Actualizar" else "Guardar")
            }
        }
    }
}