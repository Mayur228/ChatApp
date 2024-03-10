package com.theappmakerbuddy.chitchathub.chat

import com.theappmakerbuddy.chitchathub.common.model.Message
import com.theappmakerbuddy.chitchathub.common.model.MessageData

data class ChatState(
    val messages: List<MessageData> = emptyList(),
    val isLoading: Boolean = false
)