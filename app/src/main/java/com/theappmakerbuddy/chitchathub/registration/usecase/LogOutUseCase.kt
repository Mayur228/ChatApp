package com.theappmakerbuddy.chitchathub.registration.usecase

import com.theappmakerbuddy.chitchathub.registration.repository.FirebaseAuthRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) {
    operator fun invoke() {
        authRepository.logout()
    }
}