package com.theappmakerbuddy.chitchathub.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappmakerbuddy.chitchathub.registration.repository.FirebaseAuthRepository
import com.theappmakerbuddy.chitchathub.registration.repository.UserRepository
import com.theappmakerbuddy.chitchathub.utils.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository,
    private val userRepository: UserRepository
): ViewModel() {
    private var _userResponse = MutableStateFlow<Results<String>>(Results.Loading)
    val userResponse: StateFlow<Results<String>> get() = _userResponse
    fun loginWithUsername(username: String, password: String) {
        viewModelScope.launch {
//            _uiState.value = Results.Loading
//            _uiState.value = authUseCase.registerUseCase(user)
            val response = userRepository.loginUserWithUsername(username, password)
            _userResponse.value = response
        }
    }
}