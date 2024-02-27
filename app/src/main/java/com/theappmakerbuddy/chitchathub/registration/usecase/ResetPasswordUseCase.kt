package com.theappmakerbuddy.chitchathub.registration.usecase

import com.theappmakerbuddy.chitchathub.registration.repository.FirebaseAuthRepository
import com.theappmakerbuddy.chitchathub.utils.Result
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(email: String): Result<Nothing> {
        return try {
            authRepository.resetPassword(email)
            Result.Success()
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}