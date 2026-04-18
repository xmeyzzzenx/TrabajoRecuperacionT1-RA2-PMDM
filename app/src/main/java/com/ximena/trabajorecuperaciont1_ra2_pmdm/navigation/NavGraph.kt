package com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.*

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("home") },
                    label = { Text("Home") },
                    icon = {}
                )

                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("form") },
                    label = { Text("Form") },
                    icon = {}
                )

                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("profile") },
                    label = { Text("Perfil") },
                    icon = {}
                )
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("form")
            }) {
                Text("+")
            }
        }

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("form") { FormScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
        }
    }
}