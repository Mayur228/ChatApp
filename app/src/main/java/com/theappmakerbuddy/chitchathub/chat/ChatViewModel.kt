package com.theappmakerbuddy.chitchathub.chat

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theappmakerbuddy.chitchathub.network.ChatSocketService
import com.theappmakerbuddy.chitchathub.utils.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class ChatViewModel@Inject constructor(
    private val chatSocketService: ChatSocketService,
    private val savedStateHandle: SavedStateHandle

): ViewModel() {

    private val _messageText = mutableStateOf("")
    val messageText: State<String> = _messageText

    private val _state = mutableStateOf(ChatState())
    val state: State<ChatState> = _state

    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent = _toastEvent.asSharedFlow()

    fun connectToChat() {
        getAllMessages()
        savedStateHandle.get<String>("sessionId")?.let { sessionId ->
            viewModelScope.launch {
                val result = chatSocketService.initSession(sessionId = sessionId )
                when(result) {
                    is Results.Success -> {
                        chatSocketService.observeMessages()
                            .onEach { message ->
                                val newList = state.value.messages.toMutableList().apply {
                                    add(0, message.messageList.first())
                                }
                                _state.value = state.value.copy(
                                    messages = newList
                                )
                            }.launchIn(viewModelScope)
                    }
                    is Results.Error -> {
                        _toastEvent.emit(result.toString() ?: "Unknown error")
                    }

                    else -> {}
                }
            }
        }
    }

    fun onMessageChange(message: String) {
        _messageText.value = message
    }

    fun disconnect() {
        viewModelScope.launch {
            chatSocketService.closeSession()
        }
    }

    fun getAllMessages() {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
//            val result = messageService.getAllMessages()
//            _state.value = state.value.copy(
//                messages = result,
//                isLoading = false
//            )
        }
    }

    fun sendMessage() {
        viewModelScope.launch {
            if(messageText.value.isNotBlank()) {
                chatSocketService.sendMessage(messageText.value)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disconnect()
    }
}