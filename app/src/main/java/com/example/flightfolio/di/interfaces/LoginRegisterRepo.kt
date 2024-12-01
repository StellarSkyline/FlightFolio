package com.example.flightfolio.di.interfaces

interface LoginRegisterRepo {
    suspend fun registerUser(
        userName: String,
        password: String,
        repeatPassword: String,
        fullName: String,
        quickLoginPin: String
    )

}