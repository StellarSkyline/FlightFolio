package com.example.flightfolio.data.repo

import android.util.Log
import com.example.flightfolio.di.interfaces.LoginRegisterRepo
import java.io.File

class LoginRegisterRepoImpl(
    private val dataStore: File
): LoginRegisterRepo {
    override suspend fun registerUser(
        userName: String,
        password: String,
        repeatPassword: String,
        fullName: String,
        quickLoginPin: String
    ) {
        TODO("Not yet implemented")
    }

    init{
        Log.d("STLog", "RepoInitalized")
    }


}