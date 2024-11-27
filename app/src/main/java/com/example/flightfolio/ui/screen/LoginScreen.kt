package com.example.flightfolio.ui.screen

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightfolio.R
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

        Spacer(modifier = Modifier.height(70.dp))

        Box(
            modifier = Modifier.size(200.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.icn_ff_logo),
                contentDescription = "FlightFolio logo",
                contentScale = ContentScale.Fit,)
        }

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.width(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "User Name:",
                color = FFColorList.txt_primary,
                fontSize = 16.sp)

            TextField(
                modifier = Modifier.fillMaxWidth()
                    .height(40.dp),
                value = "",
                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White ),
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Password:",
                color = FFColorList.txt_primary,
                fontSize = 16.sp)

            TextField(
                modifier = Modifier.fillMaxWidth()
                    .height(40.dp),
                value = "",
                colors = OutlinedTextFieldDefaults.colors( unfocusedContainerColor = Color.White ),
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FFColorList.btn_secondary),
                onClick = {
                    //TODO: Implement Login Logic
            }) {
                Text(text = "Login", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FFColorList.btn_secondary),
                onClick = {
                    //TODO: Implement Login Logic
                }) {
                Text(text = "Register", fontSize = 16.sp)
            }
        }

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen { }
}