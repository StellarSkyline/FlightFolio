package com.example.flightfolio.di

import android.content.Context
import com.example.flightfolio.data.interfaces.UserPreferences
import com.example.flightfolio.data.repo.UserPreferencesImpl
import com.example.flightfolio.data.repo.LoginRegisterRepoImpl
import com.example.flightfolio.data.interfaces.LoginRegisterRepo

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
    fun providesDataStore(@ApplicationContext app: Context): UserPreferences = UserPreferencesImpl(app)

    @Provides
    @Singleton
    fun providesLoginRegisterRepo(dataStore: UserPreferences): LoginRegisterRepo = LoginRegisterRepoImpl(dataStore)
