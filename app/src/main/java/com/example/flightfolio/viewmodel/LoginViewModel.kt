package com.example.flightfolio.viewmodel

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val app: Application,
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