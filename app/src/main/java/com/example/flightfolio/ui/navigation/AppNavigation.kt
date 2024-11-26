package com.example.flightfolio.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.flightfolio.ui.screen.LoginScreen

@Composable
fun AppNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginGraph.route) {

        //Login Graph
        navigation(
            startDestination = Screen.LoginScreen.route,
            route = Screen.LoginGraph.route
        ) {
            composable(route = Screen.LoginScreen.route) {
                LoginScreen{}
                //TODO: Add Shared ViewModel here
            }
        }

    }
}