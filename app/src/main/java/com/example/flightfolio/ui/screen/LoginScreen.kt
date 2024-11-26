package com.example.flightfolio.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.flightfolio.ui.theme.FlightFolioTheme


@Composable
fun LoginScreen(onClick: (String) -> Any) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3D3D3))
    )

}