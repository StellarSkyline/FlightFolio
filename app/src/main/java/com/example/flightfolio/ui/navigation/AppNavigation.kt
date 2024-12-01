package com.example.flightfolio.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.flightfolio.extension.sharedViewModel
import com.example.flightfolio.ui.screen.LoginScreen
import com.example.flightfolio.viewmodel.LoginViewModel

@Composable
fun AppNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginGraph.route) {

        //Login Graph
        navigation(
            startDestination = Screen.LoginScreen.route,
            route = Screen.LoginGraph.route
        ) {
            composable(route = Screen.LoginScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<LoginViewModel>(navController)
                LoginScreen(vm = viewModel){
                    //TODO: Navigation handler
                }
            }
        }

    }
}