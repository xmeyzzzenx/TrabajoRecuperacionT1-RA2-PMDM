package com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.*
import kotlinx.coroutines.launch

// navegacion principal de la app
// aqui se define el drawer, la bottom bar y todas las rutas
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // colores del indicador de la bottom bar
    val navItemColors = NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.secondaryContainer
    )

    // funcion para navegar sin duplicar pantallas en la pila
    fun navigate(route: String) {
        navController.navigate(route) {
            popUpTo("home")
            launchSingleTop = true
        }
    }

    // drawer lateral con las opciones de navegacion
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                Text(
                    text = "Menu",
                    modifier = Modifier.padding(16.dp)
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    selected = currentRoute == "home",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigate("home")
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Description, contentDescription = "Tareas") },
                    label = { Text("Tareas") },
                    selected = currentRoute == "form",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigate("form")
                    }
                )

                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                    label = { Text("Info") },
                    selected = currentRoute == "info",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigate("info")
                    }
                )
            }
        }
    ) {

        Scaffold(

            topBar = {
                // barra superior con el nombre de la app y boton para abrir el drawer
                CenterAlignedTopAppBar(
                    title = { Text("TaskApp") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menu"
                            )
                        }
                    }
                )
            },

            bottomBar = {
                // barra de navegacion inferior con las tres secciones principales
                NavigationBar {

                    NavigationBarItem(
                        selected = currentRoute == "home",
                        onClick = { navigate("home") },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                        colors = navItemColors
                    )

                    NavigationBarItem(
                        selected = currentRoute == "form",
                        onClick = { navigate("form") },
                        icon = { Icon(Icons.Default.Description, contentDescription = "Tareas") },
                        colors = navItemColors
                    )

                    NavigationBarItem(
                        selected = currentRoute == "info",
                        onClick = { navigate("info") },
                        icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                        colors = navItemColors
                    )
                }
            },

            floatingActionButton = {
                // boton flotante para añadir tarea, solo visible en la pantalla principal
                if (currentRoute == "home") {
                    FloatingActionButton(
                        onClick = { navigate("form") },
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Añadir tarea")
                    }
                }
            }

        ) { padding ->

            // rutas de la app
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(padding)
            ) {
                composable("home") { HomeScreen(navController) }
                composable("form") { FormScreen(navController) }
                composable("info") { InfoScreen(navController) }
                composable("detail") { DetailScreen(navController) }
            }
        }
    }
}