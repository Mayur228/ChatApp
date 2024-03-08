package com.theappmakerbuddy.chitchathub.chat

import androidx.lifecycle.SavedStateHandle
import com.theappmakerbuddy.chitchathub.network.ChatSocketService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel@Inject constructor(
    private val chatSocketService: ChatSocketService,
    private val savedStateHandle: SavedStateHandle

) {
}