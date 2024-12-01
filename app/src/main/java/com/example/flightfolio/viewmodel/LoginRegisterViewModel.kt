package com.example.flightfolio.viewmodel

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginRegisterViewModel @Inject constructor(
    val app: Application,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val userName = savedStateHandle.getStateFlow(key = "userName", initialValue = "")
    val password = savedStateHandle.getStateFlow(key = "password", initialValue = "")
    val repeatPassword = savedStateHandle.getStateFlow(key = "repeatPassword", initialValue = "")
    val fullName = savedStateHandle.getStateFlow(key = "fullName", initialValue = "")
    val quickLoginPin = savedStateHandle.getStateFlow(key = "quickLoginPin", initialValue = "")

    fun changeState(
        userName: String = "",
        password: String = "",
        repeatPassword: String = "",
        fullName: String = "",
        quickLoginPin: String = "",
    ) {
        savedStateHandle["userName"] = userName
        savedStateHandle["password"] = password
        savedStateHandle["repeatPassword"] = repeatPassword
        savedStateHandle["fullName"] = fullName
        savedStateHandle["quickLoginPin"] = quickLoginPin
    }
}