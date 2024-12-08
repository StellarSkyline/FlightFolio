package com.example.flightfolio.data.interfaces

interface LoginRegisterRepo {
    suspend fun getAuthState(): String
    suspend fun loginUser(email: String, password: String): String
    suspend fun signUp(email: String, password: String): String
    suspend fun signOut():String

}