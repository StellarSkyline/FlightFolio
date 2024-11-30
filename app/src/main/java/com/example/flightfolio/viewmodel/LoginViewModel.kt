package com.example.flightfolio.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModel(
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val userName = savedStateHandle.getStateFlow(key = "userName", initialValue = "")
    val password = savedStateHandle.getStateFlow(key = "password", initialValue = "")

    fun changeState(
        userName: String = savedStateHandle["userName"] ?: "",
        password: String = savedStateHandle["password"] ?: ""
    ) {
        savedStateHandle["userName"] = userName
        savedStateHandle["password"] = password
    }
}