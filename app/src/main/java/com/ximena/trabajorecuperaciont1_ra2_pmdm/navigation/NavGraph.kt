package com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.dp
import com.ximena.trabajorecuperaciont1_ra2_pmdm.data.TaskRepository
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.*
import kotlinx.coroutines.launch

// navegacion principal de la app
// aqui se definen el drawer lateral, la bottom bar y todas las rutas
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {

    val navController = rememberNavController()
    // ruta activa para saber que item resaltar en la bottom bar y el drawer
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // color del indicador de seleccion en la bottom bar
    val navItemColors = NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.secondaryContainer
    )

    // evita duplicar pantallas en la pila de navegacion
    fun navigate(route: String) {
        navController.navigate(route) {
            popUpTo("home")
            launchSingleTop = true
        }
    }

    // drawer lateral que se abre con el boton de menu
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // fondo blanco para evitar el color por defecto de Material
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.background
            ) {

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

                // limpiamos la tarea seleccionada para abrir el formulario vacio
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Description, contentDescription = "Tareas") },
                    label = { Text("Tareas") },
                    selected = currentRoute == "form",
                    onClick = {
                        scope.launch { drawerState.close() }
                        TaskRepository.selectedTask = null
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
                // fondo blanco para evitar el color por defecto de Material
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.background
                ) {

                    NavigationBarItem(
                        selected = currentRoute == "home",
                        onClick = { navigate("home") },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                        colors = navItemColors
                    )

                    // limpiamos la tarea seleccionada al navegar al formulario desde la bottom bar
                    NavigationBarItem(
                        selected = currentRoute == "form",
                        onClick = {
                            TaskRepository.selectedTask = null
                            navigate("form")
                        },
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
                // boton + para añadir tarea, solo visible en la pantalla principal
                if (currentRoute == "home") {
                    FloatingActionButton(
                        onClick = {
                            // limpiamos la tarea seleccionada para abrir el formulario vacio
                            TaskRepository.selectedTask = null
                            navigate("form")
                        },
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Añadir tarea")
                    }
                }
            }

        ) { padding ->

            // definicion de todas las rutas de la app
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(padding)
            ) {
                composable("home") { HomeScreen(navController) }
                composable("form") { FormScreen(navController) }
                composable("info") { InfoScreen() }
                composable("detail") { DetailScreen(navController) }
            }
        }
    }
}