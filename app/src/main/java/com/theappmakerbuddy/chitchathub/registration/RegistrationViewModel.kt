package com.theappmakerbuddy.chitchathub.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappmakerbuddy.chitchathub.common.model.User
import com.theappmakerbuddy.chitchathub.registration.usecase.FirebaseAuthUseCase
import com.theappmakerbuddy.chitchathub.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authUseCase: FirebaseAuthUseCase
): ViewModel() {
    private var _uiState = MutableLiveData<Result<Nothing>>()
    val uiState: LiveData<Result<Nothing>> = _uiState

    fun register(user: User) {
        viewModelScope.launch {
            _uiState.value = Result.Loading
            _uiState.value = authUseCase.registerUseCase(user)
        }
    }
}