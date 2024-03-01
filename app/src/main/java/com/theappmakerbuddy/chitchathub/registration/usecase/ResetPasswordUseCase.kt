package com.theappmakerbuddy.chitchathub.registration.usecase

import com.theappmakerbuddy.chitchathub.registration.repository.FirebaseAuthRepository
import com.theappmakerbuddy.chitchathub.utils.Results
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(email: String): Results<Nothing> {
        return try {
            authRepository.resetPassword(email)
            Results.Success()
        } catch (e: Exception) {
            Results.Error(e)
        }
    }
}