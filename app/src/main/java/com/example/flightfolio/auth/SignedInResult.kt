package com.example.flightfolio.auth

data class SignedInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val userName: String,
    val profilePictureUrl: String?
)