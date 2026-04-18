package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun FormScreen(navController: NavController) {

    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

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

            Text("Formulario", style = MaterialTheme.typography.titleLarge)

            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                scope.launch {
                    if (titulo.isBlank() || descripcion.isBlank()) {
                        snackbarHostState.showSnackbar("Completa todos los campos")
                    } else {
                        snackbarHostState.showSnackbar("Tarea guardada correctamente")
                        titulo = ""
                        descripcion = ""
                    }
                }
            }) {
                Text("Guardar")
            }

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Volver")
            }
        }
    }
}