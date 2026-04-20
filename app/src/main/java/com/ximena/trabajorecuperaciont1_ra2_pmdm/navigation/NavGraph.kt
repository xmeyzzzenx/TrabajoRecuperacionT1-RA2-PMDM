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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navItemColors = NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.secondaryContainer
    )

    fun navigate(route: String) {
        navController.navigate(route) {
            popUpTo("home")
            launchSingleTop = true
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                Text(
                    text = "Menú",
                    modifier = Modifier.padding(16.dp)
                )

                NavigationDrawerItem(
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = "Inicio")
                    },
                    label = { Text("Inicio") },
                    selected = currentRoute == "home",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigate("home")
                    }
                )

                NavigationDrawerItem(
                    icon = {
                        Icon(Icons.Default.Description, contentDescription = "Notas")
                    },
                    label = { Text("Notas") },
                    selected = currentRoute == "form",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigate("form")
                    }
                )

                NavigationDrawerItem(
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    },
                    label = { Text("Perfil") },
                    selected = currentRoute == "profile",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navigate("profile")
                    }
                )
            }
        }
    ) {

        Scaffold(

            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("NoteApp") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú"
                            )
                        }
                    }
                )
            },

            bottomBar = {
                NavigationBar {

                    NavigationBarItem(
                        selected = currentRoute == "home",
                        onClick = { navigate("home") },
                        icon = {
                            Icon(Icons.Default.Home, contentDescription = "Inicio")
                        },
                        colors = navItemColors
                    )

                    NavigationBarItem(
                        selected = currentRoute == "form",
                        onClick = { navigate("form") },
                        icon = {
                            Icon(Icons.Default.Description, contentDescription = "Notas")
                        },
                        colors = navItemColors
                    )

                    NavigationBarItem(
                        selected = currentRoute == "profile",
                        onClick = { navigate("profile") },
                        icon = {
                            Icon(Icons.Default.Person, contentDescription = "Perfil")
                        },
                        colors = navItemColors
                    )
                }
            },

            floatingActionButton = {
                if (currentRoute == "home") {
                    FloatingActionButton(
                        onClick = { navigate("form") },
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Añadir nota")
                    }
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