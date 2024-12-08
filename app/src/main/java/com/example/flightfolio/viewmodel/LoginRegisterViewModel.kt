package com.example.flightfolio.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightfolio.data.interfaces.LoginRegisterRepo
import com.example.flightfolio.domain.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginRegisterViewModel @Inject constructor(
    val app: Application,
    val repo: LoginRegisterRepo,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    //Flows
    val emailState = savedStateHandle.getStateFlow(key = "email", initialValue = "")
    val passwordState = savedStateHandle.getStateFlow(key = "password", initialValue = "")
    val authState = savedStateHandle.getStateFlow("authState", "")

    //init check Auth Status
//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            savedStateHandle["authState"] = repo.getAuthState()
//        }
//    }


    //State Change fun
    fun changeEmailState(email: String = "", ) { savedStateHandle["email"] = email }
    fun changePasswordState(password: String = "") { savedStateHandle["password"] = password }

    fun login(email: String, password: String) {
        savedStateHandle["authState"] = AuthState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            savedStateHandle["authState"] = repo.loginUser(email, password)
        }
    }

    fun signUp() {

        savedStateHandle["authState"] = AuthState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            savedStateHandle["authState"] = repo.signUp(emailState.value, passwordState.value)
        }
    }

    fun signOut() {
        viewModelScope.launch(Dispatchers.IO) {
            savedStateHandle["authState"] = repo.signOut()
        }
    }


}