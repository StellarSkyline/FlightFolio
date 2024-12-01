package com.example.flightfolio.data.repo

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.flightfolio.data.interfaces.UserPreferences

class UserPreferencesImpl(val context: Context): UserPreferences {
    private val Context.dataStore by preferencesDataStore("user_preferences")

    init{
        Log.d("STLog", "Initalized UserPref")
    }

    override suspend fun saveItem(key: String, value: String) {
       context.dataStore.edit {
           it[stringPreferencesKey(key)] = value
       }
    }
}