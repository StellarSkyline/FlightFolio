package com.example.flightfolio.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.flightfolio.domain.AuthState
import com.example.flightfolio.ui.components.IncludeSpinner
import com.example.flightfolio.ui.components.InputText
import com.example.flightfolio.ui.components.LabelText
import com.example.flightfolio.ui.components.PasswordInputText
import com.example.flightfolio.ui.components.PrimaryButton
import com.example.flightfolio.ui.components.TitleText
import com.example.flightfolio.ui.navigation.Screen
import com.example.flightfolio.ui.theme.FFColorList
import com.example.flightfolio.viewmodel.LoginRegisterViewModel

@Composable
fun RegisterScreen(vm: LoginRegisterViewModel, onNavigate: (String) -> Any) {

    //States
    val email by vm.emailState.collectAsStateWithLifecycle()
    val password by vm.passwordState.collectAsStateWithLifecycle()
    val authState by vm.authState.collectAsStateWithLifecycle()

    //TODO: Handle data validation

    //Handle Logic
    when (authState) {
        AuthState.Authenticated -> onNavigate(Screen.LoginScreen.route)
        AuthState.Loading -> IncludeSpinner()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FFColorList.bg_color),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        TitleText(text = "Register")

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.width(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            LabelText(text = "Enter User Name:")

            InputText(
                modifier = Modifier,
                text = email
            ) {
                vm.changeEmailState(email = it)
            }

            Spacer(modifier = Modifier.height(15.dp))

            LabelText(text = "Enter Password:")

            PasswordInputText(
                modifier = Modifier,
                text = password
            ) {
                vm.changePasswordState(password = it)
            }

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(
                modifier = Modifier.width(300.dp),
                title = "Register"
            ) {
                vm.signUp()
            }

        }
    }
}
