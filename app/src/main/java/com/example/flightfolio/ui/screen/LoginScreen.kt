package com.example.flightfolio.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightfolio.ui.theme.FFColorList


@Composable
fun LoginScreen(onClick: (String) -> Any) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FFColorList.bg_color),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "FlightFolio",
            fontSize = 48.sp,
            color = FFColorList.txt_primary
        )

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen { }
}