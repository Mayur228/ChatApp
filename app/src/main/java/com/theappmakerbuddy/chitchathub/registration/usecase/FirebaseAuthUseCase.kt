package com.theappmakerbuddy.chitchathub.registration.usecase

import javax.inject.Inject

data class FirebaseAuthUseCase @Inject constructor(
    val logInUseCase: LogInUseCase,
    val registerUseCase: RegisterUseCase,
    val resetPasswordUseCase: ResetPasswordUseCase,
    val logOutUseCase: LogOutUseCase
)