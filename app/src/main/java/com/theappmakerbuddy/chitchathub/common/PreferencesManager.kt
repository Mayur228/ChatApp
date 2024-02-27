package com.theappmakerbuddy.chitchathub.common

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferencesManager(context: Context) {
     val preferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
     inline fun <reified T : Any> getPreferenceValue(
        key: String,
        defaultValue: T,
    ): T {

        return when (defaultValue) {
            is String -> preferences.getString(key, defaultValue) as T
            is Int -> preferences.getInt(key, defaultValue) as T
            is Long -> preferences.getLong(key, defaultValue) as T
            is Float -> preferences.getFloat(key, defaultValue) as T
            is Boolean -> preferences.getBoolean(key, defaultValue) as T
            is Set<*> -> preferences.getStringSet(key, defaultValue as Set<String>) as T
            else -> throw UnsupportedOperationException("Unsupported type: ${T::class.java.simpleName}")
        }
    }

    inline fun <reified T : Any> setPreferenceValue(
        key: String,
        value: T,
    ) {
        preferences.edit {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                is Set<*> -> putStringSet(key, value as Set<String>)
                else -> throw UnsupportedOperationException("Unsupported type: ${T::class.java.simpleName}")
            }
        }
    }
}

