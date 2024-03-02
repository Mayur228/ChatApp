package com.theappmakerbuddy.chitchathub.model

import com.theappmakerbuddy.chitchathub.common.model.MessageType

data class MessageRequest(
    val roomId: String,
    val senderId: String,
    val receiverId: String,
    val message: String,
    val messageType: MessageType,
    val time: String
)
