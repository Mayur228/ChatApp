package com.theappmakerbuddy.chitchathub.registration.usecase

data class FirebaseAuthUseCase(
    val logInUseCase: LogInUseCase,
    val registerUseCase: RegisterUseCase,
    val resetPasswordUseCase: ResetPasswordUseCase,
    val logOutUseCase: LogOutUseCase
)