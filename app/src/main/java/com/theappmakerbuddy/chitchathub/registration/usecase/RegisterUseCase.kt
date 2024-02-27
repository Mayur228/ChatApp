package com.theappmakerbuddy.chitchathub.registration.usecase

import com.google.firebase.auth.UserProfileChangeRequest
import com.theappmakerbuddy.chitchathub.common.model.User
import com.theappmakerbuddy.chitchathub.registration.repository.FirebaseAuthRepository
import com.theappmakerbuddy.chitchathub.utils.Result
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(
        user: User
    ): Result<Nothing> {
        return try {
            val userPP = UserProfileChangeRequest.Builder().setDisplayName(user.userName).build()
            authRepository.register(user.userName, user.email, user.phone, user.userProfile ?: userPP.toString(),user.password)
            Result.Success()
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}