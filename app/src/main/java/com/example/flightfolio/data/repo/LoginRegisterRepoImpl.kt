package com.example.flightfolio.data.repo

import android.util.Log
import com.example.flightfolio.data.interfaces.UserPreferences
import com.example.flightfolio.data.interfaces.LoginRegisterRepo

class LoginRegisterRepoImpl(
    private val dataStore: UserPreferences,

    ): LoginRegisterRepo {
    init{
        Log.d("STLog", "RepoInitalized")
    }

    override suspend fun registerUser(
        userName: String,
        password: String,
        repeatPassword: String,
        fullName: String,
        quickLoginPin: String
    ) {
        TODO("Not yet implemented")
    }

}