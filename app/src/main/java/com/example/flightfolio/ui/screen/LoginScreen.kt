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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.flightfolio.R
import com.example.flightfolio.ui.components.InputText
import com.example.flightfolio.ui.components.LabelText
import com.example.flightfolio.ui.components.PasswordInputText
import com.example.flightfolio.ui.components.PrimaryButton
import com.example.flightfolio.ui.components.TitleText
import com.example.flightfolio.ui.navigation.Screen
import com.example.flightfolio.ui.theme.FFColorList
import com.example.flightfolio.viewmodel.LoginRegisterViewModel


@Composable
fun LoginScreen(vm: LoginRegisterViewModel, onNavigate: (String) -> Any) {

    val userName by vm.userName.collectAsStateWithLifecycle()
    val password by vm.password.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FFColorList.bg_color),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        TitleText(text = "FlightFolio")

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
            LabelText(text = "User Name:")

            InputText(
                modifier = Modifier,
                text = userName
            ) {
                vm.changeState(userName = it)
            }

            Spacer(modifier = Modifier.height(15.dp))

            LabelText(text = "Password:")

            PasswordInputText(
                modifier = Modifier,
                text = password
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
                onNavigate(Screen.RegisterScreen.route)
            }
        }
    }
}