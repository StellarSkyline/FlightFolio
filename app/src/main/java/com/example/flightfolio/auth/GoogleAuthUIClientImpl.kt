package com.example.flightfolio.auth

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await

class GoogleAuthUIClientImpl(
    val app: Context,
    private val oneTapClient: SignInClient,
    private val beginSignInRequest: BeginSignInRequest
) : GoogleAuthUIClient {

    private val auth = Firebase.auth

    override suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                beginSignInRequest
            ).await()

        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }

        return result?.pendingIntent?.intentSender

    }

    override suspend fun signInWithIntent(intent: Intent): SignedInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)

        return try {

            val user = auth.signInWithCredential(googleCredentials).await().user
            SignedInResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        userName = displayName!!,
                        profilePictureUrl = photoUrl?.toString(),
                    )
                },
                errorMessage = null
            )

        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignedInResult(
                data = null,
                errorMessage = e.message
            )
        }
    }

    override suspend fun signOut() {
        try {
            oneTapClient.signOut().await()
            auth.signOut()

        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
        }
    }

    override fun getSignedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            userId = uid,
            userName = displayName!!,
            profilePictureUrl = photoUrl?.toString()
        )
    }
}