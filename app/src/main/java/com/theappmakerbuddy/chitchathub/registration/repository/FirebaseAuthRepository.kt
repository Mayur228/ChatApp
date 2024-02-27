package com.theappmakerbuddy.chitchathub.registration.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepository @Inject constructor(){
    private val auth: FirebaseAuth = Firebase.auth
    suspend fun register(
        username: String,
        email: String?,
        phone: String?,
        userProfile: String,
        password: String
    ) {
        val result = auth.createUserWithEmailAndPassword(email ?: phone ?: "" , password).await()
        result.user?.updateProfile(
            UserProfileChangeRequest.Builder().setDisplayName(username).build()
        )?.await()
    }

    suspend fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    suspend fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }

    fun logout() {
        auth.signOut()
    }
}