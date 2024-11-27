package com.example.flightfolio.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LoginViewModel(
    val savedStateHandle: SavedStateHandle,
): ViewModel() {


}