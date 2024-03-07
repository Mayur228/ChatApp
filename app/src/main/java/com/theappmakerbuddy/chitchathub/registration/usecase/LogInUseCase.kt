package com.theappmakerbuddy.chitchathub.registration.usecase

import com.theappmakerbuddy.chitchathub.registration.repository.FirebaseAuthRepository
import com.theappmakerbuddy.chitchathub.utils.Results
import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Results<Nothing> {
        return try {
            authRepository.login(email, password)
            Results.Success()
        } catch (e: Exception) {
            Results.Error(e.message.toString())
        }
    }
}