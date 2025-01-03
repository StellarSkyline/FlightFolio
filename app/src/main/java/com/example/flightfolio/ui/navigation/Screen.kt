package com.example.flightfolio.ui.navigation

sealed class Screen(val route:String) {
    object LoginScreen : Screen("login_screen")
    object LoginGraph:Screen("login_graph")
    object RegisterScreen:Screen("register_screen")
    object HomeScreen:Screen("home_screen")
    object MainGraph:Screen("main_graph")


}