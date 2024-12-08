package com.example.flightfolio.data.repo

import android.util.Log
import com.example.flightfolio.data.interfaces.LoginRegisterRepo
import com.example.flightfolio.data.interfaces.UserPreferences
import com.example.flightfolio.domain.AuthState
import com.google.firebase.auth.FirebaseAuth

class LoginRegisterRepoImpl(
    private val dataStore: UserPreferences,
) : LoginRegisterRepo {

    private val auth:FirebaseAuth = FirebaseAuth.getInstance()

    override suspend fun getAuthState(): String {
        if(auth.currentUser==null) return AuthState.UnAuthenticated
        else  return AuthState.Authenticated
    }

    override suspend fun loginUser(email:String, password:String): String {
        var authState:String = AuthState.UnAuthenticated
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful)  authState = AuthState.Authenticated
            else authState =  AuthState.UnAuthenticated
        }
        return authState
    }

    override suspend fun signUp(email: String, password: String): String {
        auth.createUserWithEmailAndPassword(email, password)
        return AuthState.Authenticated
    }

    override suspend fun signOut(): String {
        auth.signOut()
        return AuthState.UnAuthenticated
    }

}