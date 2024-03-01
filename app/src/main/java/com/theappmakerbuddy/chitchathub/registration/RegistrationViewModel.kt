package com.theappmakerbuddy.chitchathub.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappmakerbuddy.chitchathub.model.UserRequest
import com.theappmakerbuddy.chitchathub.registration.repository.UserRepository
import com.theappmakerbuddy.chitchathub.registration.usecase.FirebaseAuthUseCase
import com.theappmakerbuddy.chitchathub.utils.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authUseCase: FirebaseAuthUseCase,
    private val userRepository: UserRepository
): ViewModel() {
    private var _userResponse = MutableStateFlow<Results<String>>(Results.Loading)
    val userResponse: StateFlow<Results<String>> get() = _userResponse

    fun register(userRequest: UserRequest) {
        viewModelScope.launch {
//            _uiState.value = Results.Loading
//            _uiState.value = authUseCase.registerUseCase(user)
            val response = userRepository.registerUser(userRequest)
            _userResponse.value = response
        }
    }
}