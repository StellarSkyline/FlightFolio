package com.example.flightfolio.data.interfaces

interface LoginRegisterRepo {
    suspend fun registerUser(
        userName: String,
        password: String,
        repeatPassword: String,
        fullName: String,
        quickLoginPin: String
    )

}