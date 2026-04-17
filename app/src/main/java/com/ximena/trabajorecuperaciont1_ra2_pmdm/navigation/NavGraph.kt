package com.ximena.trabajorecuperaciont1_ra2_pmdm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.HomeScreen
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.FormScreen
import com.ximena.trabajorecuperaciont1_ra2_pmdm.screens.ProfileScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }

        composable("form") {
            FormScreen(navController)
        }

        composable("profile") {
            ProfileScreen(navController)
        }
    }
}