package com.example.flightfolio.di

import android.content.Context
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.flightfolio.data.repo.LoginRegisterRepoImpl
import com.example.flightfolio.di.interfaces.LoginRegisterRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDataStore(@ApplicationContext app: Context): File =  app.preferencesDataStoreFile("saved_user")

    @Provides
    @Singleton
    fun providesLoginRegisterRepo(dataStore:File): LoginRegisterRepo = LoginRegisterRepoImpl(dataStore)
}