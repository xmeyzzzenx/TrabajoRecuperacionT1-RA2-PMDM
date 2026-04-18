package com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.*

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {

                Text("Menú", modifier = Modifier.padding(16.dp))

                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = currentRoute == "home",
                    onClick = { navController.navigate("home")}
                )

                NavigationDrawerItem(
                    label = { Text("Formulario") },
                    selected = currentRoute == "form",
                    onClick = { navController.navigate("form") }
                )

                NavigationDrawerItem(
                    label = { Text("Perfil") },
                    selected = currentRoute == "profile",
                    onClick = { navController.navigate("profile")}
                )
            }
        }
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {

                    NavigationBarItem(
                        selected = currentRoute == "home",
                        onClick = { navController.navigate("home") },
                        label = { Text("Home") },
                        icon = {}
                    )

                    NavigationBarItem(
                        selected = currentRoute == "form",
                        onClick = { navController.navigate("form") },
                        label = { Text("Form") },
                        icon = {}
                    )

                    NavigationBarItem(
                        selected = currentRoute == "profile",
                        onClick = { navController.navigate("profile") },
                        label = { Text("Perfil") },
                        icon = {}
                    )
                }
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate("form")
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
}