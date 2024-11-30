package com.example.flightfolio.ui.screen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightfolio.R
import com.example.flightfolio.ui.components.InputText
import com.example.flightfolio.ui.components.PrimaryButton
import com.example.flightfolio.ui.theme.FFColorList
import com.example.flightfolio.viewmodel.LoginViewModel


@Composable
fun LoginScreen(onClick: (String) -> Any) {

    val vm:LoginViewModel = viewModel()
    val userNameState by vm.userName.collectAsStateWithLifecycle()
    val passwordState by vm.password.collectAsStateWithLifecycle()

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
                contentScale = ContentScale.Fit,
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.width(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "User Name:",
                color = FFColorList.txt_primary,
                fontSize = 16.sp
            )

            InputText(
                modifier = Modifier,
                text = userNameState
            ) {
                vm.changeState(userName = it)
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Password:",
                color = FFColorList.txt_primary,
                fontSize = 16.sp
            )

            InputText(
                modifier = Modifier,
                text = passwordState
            ) {
                vm.changeState(password = it)
            }

            Spacer(modifier = Modifier.height(15.dp))

            PrimaryButton(
                title = "Login"
            ) {
                //TODO: Handle Logic
            }

            Spacer(modifier = Modifier.height(15.dp))

            PrimaryButton(
                title = "Register"
            ) {
                //TODO: Handle Logic
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen { }
}