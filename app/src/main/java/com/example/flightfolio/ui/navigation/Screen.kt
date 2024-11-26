package com.example.flightfolio.ui.navigation

sealed class Screen(val route:String) {
    object LoginScreen : Screen("login_screen")


}