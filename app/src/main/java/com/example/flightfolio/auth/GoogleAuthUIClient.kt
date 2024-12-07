package com.example.flightfolio.auth

import android.content.Intent
import android.content.IntentSender

interface GoogleAuthUIClient {
    suspend fun signIn(): IntentSender?
    suspend fun signInWithIntent(intent: Intent): SignedInResult
    suspend fun signOut()
    fun getSignedInUser(): UserData?
}