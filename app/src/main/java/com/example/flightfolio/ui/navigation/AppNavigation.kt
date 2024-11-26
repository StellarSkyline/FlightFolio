package com.example.flightfolio.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

        //Login Graph
        navigation(
            startDestination = Screen.LoginScreen.route,
            route = Screen.LoginScreen.route
        ) {
            composable(route = Screen.LoginScreen.route) {
                //TODO: Add Login Composable here
                //TODO: Add Shared ViewModel here
            }
        }

    }
}