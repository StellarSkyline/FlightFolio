package com.example.flightfolio.di

import android.content.Context
import com.example.flightfolio.R
import com.example.flightfolio.auth.GoogleAuthUIClient
import com.example.flightfolio.auth.GoogleAuthUIClientImpl
import com.example.flightfolio.data.interfaces.LoginRegisterRepo
import com.example.flightfolio.data.interfaces.UserPreferences
import com.example.flightfolio.data.repo.LoginRegisterRepoImpl
import com.example.flightfolio.data.repo.UserPreferencesImpl
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDataStore(@ApplicationContext app: Context): UserPreferences =
        UserPreferencesImpl(app)

    @Provides
    @Singleton
    fun providesLoginRegisterRepo(dataStore: UserPreferences): LoginRegisterRepo =
        LoginRegisterRepoImpl(dataStore)

    @Provides
    @Singleton
    fun providesBeginSignInRequest(@ApplicationContext app: Context): BeginSignInRequest {
        return BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(app.getString(R.string.web_client_id))
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    @Provides
    @Singleton
    fun providesSignInClient(@ApplicationContext app: Context): SignInClient = Identity.getSignInClient(app)

    @Provides
    @Singleton
    fun providesGoogleAuthUIClient(@ApplicationContext app:Context, oneTapClient: SignInClient, beginSignInRequest: BeginSignInRequest): GoogleAuthUIClient = GoogleAuthUIClientImpl(app, oneTapClient, beginSignInRequest)



}




