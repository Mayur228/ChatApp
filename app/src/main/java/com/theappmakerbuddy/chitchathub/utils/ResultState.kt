package com.theappmakerbuddy.chitchathub.utils

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.StateFlow

typealias SignOutResponse = Results<Boolean>
typealias AuthStateResponse = StateFlow<FirebaseUser?>

sealed class Results<out R> {
    data object Loading : Results<Nothing>()
    data class Success<out R>(val data: R? = null) : Results<R>()
    data class Error(val exception: String) : Results<Nothing>()
}