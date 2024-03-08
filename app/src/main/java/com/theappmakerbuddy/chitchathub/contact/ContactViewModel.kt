package com.theappmakerbuddy.chitchathub.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappmakerbuddy.chitchathub.common.model.User
import com.theappmakerbuddy.chitchathub.registration.repository.UserRepository
import com.theappmakerbuddy.chitchathub.utils.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel@Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    private var _userResponse = MutableStateFlow<Results<List<User>>>(Results.Loading)
    val userResponse: StateFlow<Results<List<User>>> get() = _userResponse

    init{
        getAllUser()
    }

    private fun getAllUser() {
        viewModelScope.launch {
//            _uiState.value = Results.Loading
//            _uiState.value = authUseCase.registerUseCase(user)
            val response = userRepository.getAllUser()
            _userResponse.value = response
        }
    }
}