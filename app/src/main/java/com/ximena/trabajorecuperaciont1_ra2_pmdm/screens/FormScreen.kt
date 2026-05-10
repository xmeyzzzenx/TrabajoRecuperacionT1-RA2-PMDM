package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
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
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.TaskRepository
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Task

// formulario para crear o editar una tarea
// si hay una tarea seleccionada en el repositorio la cargamos para editarla
@Composable
fun FormScreen(navController: NavController) {

    val existingTask = TaskRepository.selectedTask

    // si estamos editando cargamos los datos, si no los campos quedan vacios
    var title by remember { mutableStateOf(existingTask?.title ?: "") }
    var description by remember { mutableStateOf(existingTask?.description ?: "") }

    // controlan si los campos tienen error de validacion
    var titleError by remember { mutableStateOf(false) }
    var descriptionError by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    // oculta el teclado al pulsar guardar
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        snackbarHost = {
            // snackbar rojo con icono de warning cuando los campos estan vacios
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // el titulo cambia segun si estamos creando o editando
            Text(
                text = if (existingTask != null) "Editar tarea" else "Nueva tarea",
                style = MaterialTheme.typography.titleLarge
            )

            // campo de titulo, se marca en rojo si esta vacio
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    titleError = it.isBlank()
                },
                label = { Text("Titulo") },
                singleLine = true,
                isError = titleError,
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    if (titleError) Text("El titulo no puede estar vacio")
                }
            )

            // campo de descripcion, se marca en rojo si esta vacio
            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                    descriptionError = it.isBlank()
                },
                label = { Text("Descripcion") },
                isError = descriptionError,
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    if (descriptionError) Text("La descripcion no puede estar vacia")
                }
            )

            Button(
                onClick = {
                    keyboardController?.hide()

                    titleError = title.isBlank()
                    descriptionError = description.isBlank()

                    // si algun campo esta vacio mostramos el snackbar
                    if (titleError || descriptionError) {
                        scope.launch {
                            snackbarHostState.showSnackbar("Completa todos los campos")
                        }
                        return@Button
                    }

                    // mantenemos el estado de completado si estamos editando
                    val newTask = Task(
                        title = title,
                        description = description,
                        isCompleted = existingTask?.isCompleted ?: false
                    )

                    if (existingTask != null) {
                        // reemplazamos la tarea en la lista
                        val index = TaskRepository.tasks.indexOf(existingTask)
                        if (index != -1) {
                            TaskRepository.tasks[index] = newTask
                        }
                    } else {
                        // añadimos la tarea nueva al repositorio
                        TaskRepository.tasks.add(newTask)
                    }

                    TaskRepository.selectedTask = null

                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(if (existingTask != null) "Actualizar" else "Guardar")
            }
        }
    }
}