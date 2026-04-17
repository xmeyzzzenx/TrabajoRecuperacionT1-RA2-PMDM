package com.ximena.trabajorecuperaciont1_ra2_pmdm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.components.TaskCard
import com.ximena.trabajorecuperaciont1_ra2_pmdm.model.Task

@Composable
fun HomeScreen(navController: NavController) {

    val tareas = listOf(
        Task("Proyecto final", "Seguir avanzando la app"),
        Task("Recuperación PMDM","Ir terminando la app"),
        Task("Recuperación PSP","Repasar hilos y corrutinas")
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Text("Lista de tareas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn (
            modifier = Modifier.weight(1f)
        ){
            items(tareas) { tarea ->
                TaskCard(tarea)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("form")
        }) {
            Text("Ir a Formulario")
        }

        Button(onClick = {
            navController.navigate("profile")
        }) {
            Text("Ir a Perfil")
        }
    }
}