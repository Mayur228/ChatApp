package com.theappmakerbuddy.chitchathub.registration.repository

import android.util.Log
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.GoogleAuthProvider
import com.theappmakerbuddy.chitchathub.utils.Results
import com.theappmakerbuddy.chitchathub.utils.SignOutResponse
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class FirebaseAuthRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private var oneTapClient: SignInClient,
    @Named("signInRequest") private var signInRequest: BeginSignInRequest,
    @Named("signUpRequest") private var signUpRequest: BeginSignInRequest,
){
//    private val auth: FirebaseAuth = Firebase.auth

    suspend fun onTapSignIn(): Results<BeginSignInResult> {
        return try {
            // 1.
            val signInResult = oneTapClient.beginSignIn(signInRequest).await()
            Results.Success(signInResult)
        } catch (e: Exception) {
            try {
                // 2.
                val signUpResult = oneTapClient.beginSignIn(signUpRequest).await()
                Results.Success(signUpResult)
            } catch(e: Exception) {
                Results.Error(e.message.toString())
            }
        }
    }

    private suspend fun authenticateUser(credential: AuthCredential): Results<AuthResult> {
        return if (auth.currentUser != null) {
            authLink(credential)
        } else {
            authSignIn(credential)
        }
    }

    private suspend fun authSignIn(credential: AuthCredential): Results<AuthResult> {
        return try {
            val authResult = auth.signInWithCredential(credential).await()
            Log.i("TAG", "User: ${authResult?.user?.uid}")
//            DataProvider.updateAuthState(authResult?.user
            Results.Success(authResult)
        }
        catch (error: Exception) {
            Results.Error(error.message.toString())
        }
    }

    private suspend fun authLink(credential: AuthCredential): Results<AuthResult> {
        return try {
            val authResult = auth.currentUser?.linkWithCredential(credential)?.await()
            Log.i("TAG", "User: ${authResult?.user?.uid}")
//            DataProvider.updateAuthState(authResult?.user)
            Results.Success(authResult)
        }
        catch (error: FirebaseAuthException) {
            when (error.errorCode) {
                "ERROR_CREDENTIAL_ALREADY_IN_USE",
                "ERROR_EMAIL_ALREADY_IN_USE" -> {
                    Log.e("TAG", "FirebaseAuthError: authLink(credential:) failed, ${error.message}")
                    return authSignIn(credential)
                }
            }
            Results.Error(error.message.toString())

        }
        catch (error: Exception) {
            Results.Error(error.message.toString())

        }
    }

    suspend fun signInWithGoogle(credential: SignInCredential): Results<AuthResult> {
        // 1.
        val googleCredential = GoogleAuthProvider
            .getCredential(credential.googleIdToken, null)
        // 2.
        return authenticateUser(googleCredential)
    }

    suspend fun logout(): SignOutResponse {
        return try {
            oneTapClient.signOut().await()
            auth.signOut()
            Results.Success(true)
        }
        catch (e: java.lang.Exception) {
            Results.Error(e.toString())
        }
    }
}